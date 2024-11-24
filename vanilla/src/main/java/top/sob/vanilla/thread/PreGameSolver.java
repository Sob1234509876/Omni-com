package top.sob.vanilla.thread;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.Objects;

import org.apache.log4j.Logger;
import top.sob.core.Utilities;

import top.sob.vanilla.event.ClientEventBus;
import top.sob.vanilla.event.ServerEventBus;

import top.sob.vanilla.handler.DefUEHandler;

import top.sob.vanilla.listener.ClientSideListener;
import top.sob.vanilla.listener.ServerSideListener;

import static top.sob.core.ui.Graphic.INPUT;
import static top.sob.core.ui.Graphic.OUTPUT;
import static top.sob.core.api.Meta.SAVES_URI;

import static top.sob.vanilla.Meta.LANG;

public final class PreGameSolver extends Thread {

    private static final Logger LOGGER = Logger.getLogger(PreGameSolver.class);

    private static final String PLAY_CMD = "PLAY";
    private static final String CNS_CMD = "CNS";
    private static final String HELP_CMD = "HELP";
    private static final String SINGLE_PLAYER_MODE = "S";
    private static final String MULTI_PLAYER_MODE = "M";
    // private static final String MK_SERVER_CMD = "MKS";
    // TODO: just finish this!!!!!!

    public static final int DEF_PORT = 10000;
    public static final int DEF_BACKLOG = Runtime.getRuntime().availableProcessors();
    public static final String LOCAL_SERVER_URL = "http://localhost:10000/cmd/";

    private static final Server server;
    private static final Client client;

    static {
        try {
            server = new Server(DEF_PORT, DEF_BACKLOG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        client = new Client();
    }

    @SuppressWarnings("unused")
    public PreGameSolver(String name) {
        super(name);
    }

    @Override
    public void run() {
        LOGGER.info("Pre-game cmd solver started!");
        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());

        String buffer;

        try {
            label:
            while (true) {
                buffer = INPUT.waitAndGetSubmit().toUpperCase();
                // Works now.
                LOGGER.info("User entered \"" + buffer + "\"");

                switch (buffer) {
                    case HELP_CMD:
                        writeHelp();
                        break;
                    case CNS_CMD:
                        createNewSave();
                        break label;
                    case PLAY_CMD:
                        play();
                        break label;
                    // The break is a temporary fix for the pgs not stopping
                    // on getting the submit of INPUT.
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }
    }

    private static void play() throws IOException {
        OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "play", "askMode"));

        label:
        while (true) {

            String mode = INPUT.waitAndGetSubmit().toUpperCase();

            switch (mode) {

                case SINGLE_PLAYER_MODE -> {
                    OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "play", "askFile"));

                    play(new File(INPUT.waitAndGetSubmit()));

                    break label;
                }

                case MULTI_PLAYER_MODE -> {

                    OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "play", "askHost"));
                    String host = INPUT.waitAndGetSubmit();

                    OUTPUT.setText(String.format(Objects.requireNonNull(Utilities.getConfig(LANG, "vanilla", "pre", "play", "askPort")), DEF_PORT));
                    String port = INPUT.waitAndGetSubmit();

                    URL url = new URL(String.format("http://%s:%s/cmd/", host, port));

                    play(url);
                    break label;
                }

                default -> OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "unknownCmd"));
            }

        }

    }

    private static void play(File save) throws IOException {

        OUTPUT.setText(null);

        ClientEventBus.getEventBus().register(new ClientSideListener());
        ServerEventBus.getEventBus().register(new ServerSideListener());

        server.setSaveFile(save).start();

        client.setServerURL(new URL(LOCAL_SERVER_URL)).start();

    }

    private static void play(URL url) throws IOException {
        client.setServerURL(url).start();
    }

    private static void createNewSave() throws IOException {
        OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "cns"));

        String name = INPUT.waitAndGetSubmit();
        File saveDir = new File(SAVES_URI.getPath(), name);
        @SuppressWarnings("unused") var v0 = saveDir.mkdir(); // Make save directory
        @SuppressWarnings("unused") var v1 = new File(saveDir, "main.dat").createNewFile(); // Make main save file

        OUTPUT.setText(null);

        play(saveDir);
    }

    private static void writeHelp() {

        OUTPUT.setText(Utilities.getConfig(LANG, "vanilla", "pre", "help"));

    }

}
