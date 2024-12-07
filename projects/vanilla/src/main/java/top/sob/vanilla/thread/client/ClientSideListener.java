package top.sob.vanilla.thread.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import javax.swing.ImageIcon;

import com.google.common.eventbus.Subscribe;
import org.apache.log4j.Logger;


import top.sob.core.utils.UIUtils;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.Response;
import top.sob.vanilla.Event;
import top.sob.vanilla.exceptions.proof.WIPException;
import top.sob.vanilla.ui.Graphic;
import top.sob.vanilla.utils.HttpUtils;
import top.sob.vanilla.utils.CommonUtils;

public class ClientSideListener {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(ClientSideListener.class);

    @SuppressWarnings("unused")
    @Subscribe
    public void act(Object e) throws IOException {

        var event = CommonUtils.requireInstanceOf(e, ClientEvent.class);

        Objects.requireNonNull(event);

        var type = Objects.requireNonNull(
                CommonUtils.requireInstanceOf(
                        event.getHeader()
                                .get(Event.TYPE),
                        ClientEvents.class));

        switch (type) {
            case ClientSideReceive -> mainAct(
                    Objects.requireNonNull(
                            CommonUtils.requireInstanceOf(
                                    event.getBody(),
                                    Response.class)));

            case SubmitCmd -> constructNSubmit(
                    event.getBody()
                            .toString(),
                    CommonUtils.requireInstanceOf(
                            event.getHeader()
                                    .get(Client.TARGET_URL),
                            URL.class));
        }

    }

    // Output stuffs
    private void mainAct(Response<?> response) {

        Objects.requireNonNull(response.getBody());

        switch (response.getHeader().get(Graphic.SHOWING_WAY_PROPERTY).toString()) {
            case Graphic.PLAIN_TEXT -> {
                UIUtils.out.flush();
                UIUtils.out.println(response.getBody());
            }

            case Graphic.WRAPPED_TEXT -> {

                Graphic.out.flush();
                Graphic.out.println(response.getBody());

                top.sob.core.ui.Graphic.INFO_FRAME.setVisible(true);
            }

            case Graphic.URL_IMG -> {
                Graphic.PIC_COMP.setImage(
                        new ImageIcon(
                                Objects.requireNonNull(
                                        CommonUtils.requireInstanceOf(
                                                response.getBody(),
                                                URL.class))));
                Graphic.IMG_FRAME.setVisible(true);
            }
        }

    }

    private void constructNSubmit(String in, URL turl) throws IOException {
        var op = constructOperation(in);
        var conn = CommonUtils.requireInstanceOf(turl.openConnection(), HttpURLConnection.class);
        conn.connect();
        HttpUtils.writeToConn(conn, op);
        ClientEventBus.getEventBus()
                .post(
                        new ClientEvent<>(
                                ClientEvents.ClientSideReceive,
                                HttpUtils.readFromConn(conn)));
    }

    @SuppressWarnings("unused")
    private Operation constructOperation(String in) {
        throw new WIPException();
    }

}
