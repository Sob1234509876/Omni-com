package vanilla.net;

import game.io.*;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently use for testing.
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class LClient implements Runnable {

    public  static client S;
    private static String buffer;

    public static volatile String SEND_CMD;
    public static volatile String GOT_DATA;

    public void run() {

        try {

            output.log("Recv : " + writeNread("WOW, THIS STILL WORKS!!!"));
            output.log("Recv : " + readNwrite("YES, IT WORKED!!!"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String read() {
        try {

            LClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = LClient.S.read();
            LClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }

    }

    private static void write(String data) {
        try {

            LClient.S = new client(8080, Inet6Address.getLocalHost());
            LClient.S.write(data);
            LClient.S.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    private static String readNwrite(String data) {
        try {

            LClient.S = new client(8080, Inet6Address.getLocalHost());
            buffer = LClient.S.read();
            LClient.S.write(data);
            LClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

    private static String writeNread(String data) {
        try {

            LClient.S = new client(8080, Inet6Address.getLocalHost());
            LClient.S.write(data);
            buffer = LClient.S.read();
            LClient.S.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }
}
