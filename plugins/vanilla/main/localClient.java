package vanilla.main;

import src.io.*;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently used for testing.
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class localClient implements Runnable {

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

            localClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = localClient.S.read();
            localClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }

    }

    private static void write(String data) {
        try {

            localClient.S = new client(8080, Inet6Address.getLocalHost());
            localClient.S.write(data);
            localClient.S.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    private static String readNwrite(String data) {
        try {

            localClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = localClient.S.read();
            localClient.S.write(data);
            localClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

    private static String writeNread(String data) {
        try {

            localClient.S = new client(8080, Inet6Address.getLocalHost());
            localClient.S.write(data);
            buffer = localClient.S.read();
            localClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }
}
