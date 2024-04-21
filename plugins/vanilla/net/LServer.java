package vanilla.net;

import game.io.*;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently use for testing
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class LServer implements Runnable {

    public  static server SS;
    private static String buffer;
    
    public static volatile String SEND_DATA;
    public static volatile String GOT_CMD;

    public void run() {

        try {

            output.log("Recv : " + readNwrite("OMG?!?!?"));
            output.log("Recv : " + writeNread("WOW!"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String read() {
        try {

            LServer.SS = new server(8080, Inet6Address.getLocalHost());
            LServer.SS.start();
            buffer = LServer.SS.read();
            LServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }

    }

    private static void write(String data) {
        try {

            LServer.SS = new server(8080, Inet6Address.getLocalHost());
            LServer.SS.start();
            LServer.SS.write(data);
            LServer.SS.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    private static String readNwrite(String data) {
        try {

            LServer.SS = new server(8080, Inet6Address.getLocalHost());
            LServer.SS.start();
            buffer = LServer.SS.read();
            LServer.SS.write(data);
            LServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

    private static String writeNread(String data) {
        try {

            LServer.SS = new server(8080, Inet6Address.getLocalHost());
            LServer.SS.start();
            LServer.SS.write(data);
            buffer = LServer.SS.read();
            LServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

}
