package top.sob.vanilla;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import top.sob.core.Buses;
import top.sob.vanilla.exceptions.MissingResourceException;
import top.sob.vanilla.handler.DefUEHandler;
import top.sob.vanilla.listener.BasicListener;

import static top.sob.vanilla.Meta.*;

public final class Main {

    public static final Logger LOGGER = Logger.getLogger("Vanilla");
    private static final int BUFFER_SIZE = 8192;

    private Main() {
    }

    public static void main(String[] args) throws IOException {

        LOGGER.info("Vanilla run! Hooray!");
        init();


        Buses.getRootBus().register(new BasicListener());

    }

    private static void init() throws IOException {

        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());

        // Copy file
        File file = new File(TMP_FILE_DIR, INDEX_NAME);
        InputStream is = Main.class.getClassLoader().getResourceAsStream(INDEX_NAME);

        if (is == null)
            throw new MissingResourceException(INDEX_NAME);

        OutputStream os = new FileOutputStream(file);
        byte[] buffer = new byte[BUFFER_SIZE];
        int len;

        // I/O
        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }

        os.close();
        is.close();

    }
}