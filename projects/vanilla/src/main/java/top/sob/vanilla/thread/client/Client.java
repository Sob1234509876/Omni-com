package top.sob.vanilla.thread.client;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import java.util.Objects;
import java.util.Properties;

import org.apache.log4j.Logger;

import top.sob.core.ui.Graphic;

import top.sob.vanilla.Event;
import top.sob.vanilla.utils.DefUEHandler;
import top.sob.vanilla.utils.HttpUtils;

public class Client extends Thread {

    private URL url;
    public static final String TARGET_URL = "target url";

    private static final Logger LOGGER = Logger.getLogger(Client.class);

    @SuppressWarnings("unused")
    public Client() {
        super("Client");

    }

    public synchronized Client setServerURL(URL url) throws IOException {
        Objects.requireNonNull(url);

        if (!url.getProtocol().equals("http")) {
            throw new ProtocolException(String.format("Illegal protocol %s, only http is allowed", url.getProtocol()));
        }

        this.url = url;

        return this;
    }

    @Override
    public void run() {

        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());

        try {

            LOGGER.info("Client started...");
            var p = new Properties();
            p.put(Event.TYPE, ClientEvents.SubmitCmd);
            p.put(TARGET_URL, url);

            for (; ; ) {

                ClientEventBus.getEventBus()
                        .post(
                                new ClientEvent<>(
                                        p,
                                        Graphic.INPUT
                                                .waitAndGetSubmit()
                                                .toUpperCase())); // Fires event

            }

        } catch (Exception e) {
            LOGGER.fatal("Fatal exception:", e);
        }
    }

    // Shows the received data and shows it (Done in ClientSideListener)
    @SuppressWarnings("unused")
    private void read(HttpURLConnection conn) throws IOException {

        var res = HttpUtils.readFromConn(conn);
        ClientEventBus.getEventBus().post(new ClientEvent<>(ClientEvents.ClientSideReceive, res));
        conn.disconnect();

    }

}
