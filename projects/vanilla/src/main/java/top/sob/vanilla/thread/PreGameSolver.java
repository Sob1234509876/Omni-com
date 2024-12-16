package top.sob.vanilla.thread;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import org.apache.log4j.Logger;

import top.sob.core.utils.UIUtils;
import top.sob.vanilla.proof.WIPException;
import top.sob.vanilla.thread.client.Client;
import top.sob.vanilla.thread.client.ClientEventBus;
import top.sob.vanilla.thread.server.Server;

import top.sob.vanilla.utils.DefUEHandler;

import top.sob.vanilla.thread.client.ClientSideListener;
import top.sob.vanilla.utils.TranslationUtils;

import static top.sob.core.Meta.SAVES_URI;

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
            throw new RuntimeException("IDK why :", e);
        }
        client = new Client();

        LOGGER.fatal("WIP :", new WIPException());

    }

    @SuppressWarnings("unused")
    public PreGameSolver(String name) {
        super(name);
    }

    @Override
    public void run() {
        LOGGER.info("Pre-game cmd solver started!");
        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());

        var buffer = (String) null;

        try {
            label:
            while (true) {
                buffer = UIUtils.in.readLine().toUpperCase();

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

                    default:
                        UIUtils.out.flush();
                        UIUtils.out.println(TranslationUtils.UNKNOWN_CMD);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception: ", e);
        }
    }

    private static void play() throws IOException {

        UIUtils.out.flush();
        UIUtils.out.println(TranslationUtils.ASK_MODE);

        label:
        while (true) {

            var mode = UIUtils.in.readLine().toUpperCase();

            switch (mode) {

                case SINGLE_PLAYER_MODE -> {
                    var save = UIUtils.getInput(TranslationUtils.ASK_SAVE, File.class);

                    play(save);

                    break label;
                }

                case MULTI_PLAYER_MODE -> {

                    var host = UIUtils.getInput(TranslationUtils.ASK_HOST);
                    var port = UIUtils.getInput(TranslationUtils.ASK_PORT, Integer.class);

                    var url = new URL(String.format("http://%s:%s/cmd/", host, port));

                    play(url);
                    break label;
                }

                default -> UIUtils.out.println(TranslationUtils.UNKNOWN_CMD);
            }

        }

    }

    private static void play(File save) throws IOException {

        UIUtils.out.flush();

        ClientEventBus.getEventBus().register(new ClientSideListener());

        server.setSaveFile(save).start();

        client.setServerURL(new URL(LOCAL_SERVER_URL)).start();

    }

    private static void play(URL url) throws IOException {
        client.setServerURL(url).start();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void createNewSave() throws IOException {

        var name = UIUtils.getInput(TranslationUtils.ASK_SAVE);

        var saveDir = new File(SAVES_URI.getPath(), name);
        saveDir.mkdirs(); // Make save directory
        new File(saveDir, "main.dat").createNewFile(); // Make main save file

        play(saveDir);
    }

    private static void writeHelp() {

        UIUtils.out.println(TranslationUtils.HELP_CONTENT);

    }

}
