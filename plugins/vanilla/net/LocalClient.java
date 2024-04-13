package vanilla.net;

import game.io.*;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently used for testing.
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class LocalClient implements Runnable {

    public static client S;
    private static String buffer;

    public void run() {

        try {

            output.log(writeNread("WOW, THIS STILL WORKS!!!"));
            output.log(read());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String read() {
        try {

            LocalClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = LocalClient.S.read();
            LocalClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }

    }

    private static void write(String data) {
        try {

            LocalClient.S = new client(8080, Inet6Address.getLocalHost());
            LocalClient.S.write(data);
            LocalClient.S.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    private static String readNwrite(String data) {
        try {

            LocalClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = LocalClient.S.read();
            LocalClient.S.write(data);
            LocalClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

    private static String writeNread(String data) {
        try {

            LocalClient.S = new client(8080, Inet6Address.getLocalHost());
            LocalClient.S.write(data);
            buffer = LocalClient.S.read();
            LocalClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }
}
