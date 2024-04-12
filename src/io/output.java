package src.io;

import src.main.Main;

import java.util.Date;

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
        System.out.printf("[%s/%s][%s] %s\n", new Date().toString(), type, Thread.currentThread().getName(), message);
        System.err.printf("[%s/%s][%s] %s\n", new Date().toString(), type, Thread.currentThread().getName(), message);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void write() {
        Main.OutTextArea.setText(null);
    }

    public static void write(Object x) {
        Main.OutTextArea.setText(x.toString());
    }

}
