package game.io;

import game.main.*;

import java.text.*;

import java.util.*;

/**
 * A little io system that is used for making cleaner code. Note : the
 * {@code clear()} method is used for cleaning the output of {@code System.out}.
 */
public class output {

    public static void log() {
        log("");
    }

    public static void log(Object message) {
        log(message, "ANNOUNCE");
    }

    public static void log(Object message, String type) {

        if (message instanceof Throwable) {
            Throwable t = (Throwable) (message);
            t.printStackTrace();
            System.exit(1);
        }

        if (message instanceof Object[]) {
            message = Arrays.toString((Object[]) message);
        }

        System.out.printf("[%s/%s][%s] %s\n", new SimpleDateFormat("hh:mm:ss").format(new Date()), type,
                Thread.currentThread().getName(), message);
        System.err.printf("[%s/%s][%s] %s\n", new SimpleDateFormat("hh:mm:ss").format(new Date()), type,
                Thread.currentThread().getName(), message);

    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void write() {
        Main.OutTextArea.setText(null);
    }

    public static void write(Object x) {
        if (x == null) {
            write();
            return;
        }
        Main.OutTextArea.setText(x.toString());
    }

    public static String translate(String key) {
        return Main.LangSettings.getProperty(key);
    }

}
