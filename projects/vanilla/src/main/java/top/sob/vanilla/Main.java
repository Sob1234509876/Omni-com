package top.sob.vanilla;

import java.io.IOException;

import org.apache.log4j.Logger;

import top.sob.core.annotations.api.Plugin;

import top.sob.core.exceptions.MissingResourceException;
import top.sob.core.utils.io.tmp.TmpFile;
import top.sob.core.utils.io.tmp.TmpFileOutputStream;
import top.sob.vanilla.utils.DefUEHandler;

import static top.sob.vanilla.Meta.*;

@Plugin
public final class Main implements Runnable {

    public static final Logger LOGGER = Logger.getLogger("Vanilla");
    private static final int BUFFER_SIZE = 8192;

    @SuppressWarnings("unused")
    public void init() throws IOException {

        Thread.setDefaultUncaughtExceptionHandler(new DefUEHandler());

        LOGGER.info("Vanilla run! Hooray!");

        copyFiles();

        Initialize.runGTInit();

    }

    @Override
    public void run() {
        Initialize.runGameLogicInit();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void copyFiles() throws IOException {
        var is = Main.class.getClassLoader().getResourceAsStream(INDEX_NAME);

        if (is == null)
            throw new MissingResourceException(INDEX_NAME);

        var tmp = new TmpFile(INDEX_NAME);
        tmp.getParentFile().mkdirs();
        tmp.createNewFile();

        var os = new TmpFileOutputStream(INDEX_NAME);
        var buffer = new byte[BUFFER_SIZE];
        var len = 0;

        // I/O
        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }

        os.close();
        is.close();
    }


}