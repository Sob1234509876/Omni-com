package top.sob.vanilla.listener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import javax.swing.ImageIcon;

import com.google.common.eventbus.Subscribe;
import org.apache.log4j.Logger;

import top.sob.core.ui.Graphic;

import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.Response;
import top.sob.vanilla.event.ClientEvent;
import top.sob.vanilla.event.ClientEventBus;
import top.sob.vanilla.event.ClientEvents;
import top.sob.vanilla.event.Event;
import top.sob.vanilla.thread.Client;
import top.sob.vanilla.util.HttpUtil;
import top.sob.vanilla.util.RandomUtil;

/*
*
                conn.connect();

                LOGGER.info("Connected on " + url + "...");

                HttpUtil.writeToConn(conn, input);
                read(conn);
* */

public class ClientSideListener {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(ClientSideListener.class);

    @SuppressWarnings("unused")
    @Subscribe
    public void act(Object e) throws IOException {

        var event = RandomUtil.requireInstanceOf(e, ClientEvent.class);

        Objects.requireNonNull(event);

        var type = Objects.requireNonNull(
                RandomUtil.requireInstanceOf(
                        event.getHeader()
                                .get(Event.TYPE),
                        ClientEvents.class));

        switch (type) {
            case ClientSideReceive -> mainAct(
                    Objects.requireNonNull(
                            RandomUtil.requireInstanceOf(
                                    event.getBody(),
                                    Response.class)));

            case SubmitCmd -> constructNSubmit(
                    Objects.requireNonNull(
                                    event.getBody())
                            .toString(),
                    RandomUtil.requireInstanceOf(
                            event.getHeader()
                                    .get(Client.TARGET_URL),
                            URL.class));
        }

    }

    // Output stuffs
    private void mainAct(Response<?> response) {

        Objects.requireNonNull(response.getBody());

        switch (response.getHeader().get("ShowWay").toString()) {
            case "TEXT/PLAIN" -> Graphic.OUTPUT.setText(response.getBody().toString());

            case "TEXT/WRAP" -> {
                top.sob.vanilla.ui.Graphic.INFO_TEXT.setText(response.getBody().toString());
                Graphic.INFO_FRAME.setVisible(true);
            }

            case "PICT/URL" -> top.sob.vanilla.ui.Graphic.PIC_COMP.setImage(
                    new ImageIcon(
                            Objects.requireNonNull(
                                    RandomUtil.requireInstanceOf(
                                            response.getBody(),
                                            URL.class))));
        }

    }

    private void constructNSubmit(String in, URL turl) throws IOException {
        var op = constructOperation(in);
        var conn = RandomUtil.requireInstanceOf(turl.openConnection(), HttpURLConnection.class);
        conn.connect();
        HttpUtil.writeToConn(conn, op);
        ClientEventBus.getEventBus()
                .post(
                        new ClientEvent<>(
                                ClientEvents.ClientSideReceive,
                                HttpUtil.readFromConn(conn)));
    }

    @SuppressWarnings("unused")
    private Operation<?> constructOperation(String in) {

        // TODO: Make this able to construct operations

        return null;

    }

}
