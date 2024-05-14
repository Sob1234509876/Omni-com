package vanilla.net;

import game.io.*;

import vanilla.utils.*;

import java.io.*;
import java.net.*;

/**
 * Currently use for testing
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class LServer extends Thread {

    public static volatile socket S;

    private static String Buffer;

    public static int PORT;
    public static InetAddress IP;

    public static volatile String SEND_DATA;
    public static volatile String GOT_CMD;

    public static volatile int FLOW_NUMBER;

    public void run() {

        output.log("SERVER START");

        new LServerCMDSolver().start();
        new LCMDTimer().start();

        try {

            LInit();

            while (true) {
                while (GOT_CMD == null) {
                    GOT_CMD = read();
                }
                output.log("CMD: " + GOT_CMD);
                while (SEND_DATA == null)
                    Thread.sleep(50);
                output.log("SEND: " + SEND_DATA);
                write(SEND_DATA);
                SEND_DATA = null;

                FLOW_NUMBER ++;
            }

        } catch (Exception e) {
            output.log(e);
        }

    }

    private static void LInit() throws UnknownHostException, SocketException {
        PORT = 9001;
        IP = Inet6Address.getLoopbackAddress();
        S = new socket(PORT, IP);
        S.connect(LClient.PORT, LClient.IP);
    }

    /**
     * Reads from the server socket.
     * 
     * @return the client IS
     */
    private static String read() throws IOException {

        LServer.Buffer = S.read();
        return Buffer;

    }

    /**
     * Writes to the client socket.
     * 
     * @param data the data to the OS
     */
    private static void write(String data) throws IOException {

        S.write(data);

    }

    public LServer() {
        super.setName("Server");
    }

}
