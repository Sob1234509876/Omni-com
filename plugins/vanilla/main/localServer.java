package vanilla.main;

import src.io.*;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently used for testing
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class localServer implements Runnable {

    public static server SS;
    private static String buffer;

    public void run() {

        try {

            output.log(readNwrite("OMG?!?!?"));
            write("HOW DID IT WORKED????");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String read() {
        try {

            localServer.SS = new server(8080, Inet6Address.getLocalHost());
            localServer.SS.start();
            buffer = localServer.SS.read();
            localServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }

    }

    private static void write(String data) {
        try {

            localServer.SS = new server(8080, Inet6Address.getLocalHost());
            localServer.SS.start();
            localServer.SS.write(data);
            localServer.SS.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    private static String readNwrite(String data) {
        try {

            localServer.SS = new server(8080, Inet6Address.getLocalHost());
            localServer.SS.start();
            buffer = localServer.SS.read();
            localServer.SS.write(data);
            localServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

    private static String writeNread(String data) {
        try {

            localServer.SS = new server(8080, Inet6Address.getLocalHost());
            localServer.SS.start();
            localServer.SS.write(data);
            buffer = localServer.SS.read();
            localServer.SS.close();
            return buffer;

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            return new String();
        }
    }

}
