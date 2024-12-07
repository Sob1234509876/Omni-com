package top.sob.vanilla.thread.server;

import java.io.*;

import java.net.InetSocketAddress;

import java.util.Objects;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import org.apache.log4j.Logger;
import top.sob.vanilla.utils.DefUEHandler;
import top.sob.vanilla.utils.HttpUtils;

public class Server extends Thread {

    private static final Logger LOGGER = Logger.getLogger(Server.class);

    public final static int EXC_AMOUNT = Runtime.getRuntime().availableProcessors() + 2; // For possible maximum usage of
    // cpu.
    public final static String DEF_INDEX_CONTEXT = "/";
    public final static String DEF_CMD_CONTEXT = "/cmd";

    private final HttpServer server;
    private File saveFile;

    @SuppressWarnings("unused")
    public Server(int port, int backlog) throws IOException {
        server = HttpServer.create(new InetSocketAddress(HttpUtils.getThisAddress(), port), backlog);
    }

    @Override
    public void run() {

        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());
        server.createContext(DEF_CMD_CONTEXT, new BackAPIHandler());
        server.createContext(DEF_INDEX_CONTEXT, new FrontHtmlHandler());

        server.setExecutor(Executors.newFixedThreadPool(EXC_AMOUNT));
        server.start();
        LOGGER.info("Server started...");

    }

    public synchronized Server setSaveFile(File file) {
        Objects.requireNonNull(file);

        this.saveFile = file;

        return this;
    }

    public synchronized File getSaveFile() {
        return saveFile;
    }
}
