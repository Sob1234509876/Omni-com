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
public class LServer implements Runnable {

    public static volatile socket S;

    private static String Buffer;
    private static Thread SERVER_CMD_SOLVER_THREAD = new Thread(new LServerCMDSolver(), "local server cmd solver"),
                          CMD_TIMER = new Thread(new LCMDTimer(), "local cmd timer");

    public static int PORT;
    public static InetAddress IP;
    
    public static volatile String SEND_DATA;
    public static volatile String GOT_CMD;

    public void run() {

        output.log("SERVER START");

        SERVER_CMD_SOLVER_THREAD.start();
        CMD_TIMER.start();

        try {

            LInit();

            while (true) {
                while (GOT_CMD == null) {
                    GOT_CMD = read();
                }
                while (SEND_DATA == null) Thread.sleep(50);
                write(SEND_DATA);
                SEND_DATA = null;
            }

        } catch (Exception e) {
            output.log(e);
        }

    }

    private static void LInit() throws UnknownHostException, SocketException {
        PORT = 9001;
        IP   = Inet6Address.getLoopbackAddress();
        S = new socket(PORT, IP);
    }

    /**
     * Reads from the server socket.
     * @return the client IS
     */
    private static String read() throws IOException {

        LServer.Buffer = S.read();
        return Buffer;

    }

    /**
     * Writes to the client socket.
     * @param data the data to the OS
     */
    private static void write(String data) throws IOException {

        S.connect(LClient.PORT, LClient.IP);
        S.write(data);

    }

}
