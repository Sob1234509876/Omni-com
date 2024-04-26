package vanilla.net;

import game.io.*;

import vanilla.utils.*;

import java.io.IOException;
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
    private static Thread SERVER_CMD_SOLVER_THREAD = new Thread(new LServerCMDSolver(), "local server cmd solver");

    public static int PORT;
    public static InetAddress IP;
    
    public static volatile String SEND_DATA;
    public static volatile String GOT_CMD;

    public void run() {

        SERVER_CMD_SOLVER_THREAD.start();

        try {

            LInit();

            while (true) {
                output.log("LISTENING...");
                GOT_CMD = read();
                while (SEND_DATA == null);
                write(SEND_DATA);
                SEND_DATA = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }

    }

    private static void LInit() throws UnknownHostException {
        PORT = 9001;
        IP   = Inet6Address.getLoopbackAddress();
    }

    /**
     * Reads from the server socket.
     * @return the client IS
     */
    private static String read() throws IOException {

        S = new socket(PORT, IP);
        LServer.Buffer = S.read();
        S.close();
        return Buffer;

    }

    /**
     * Writes to the client socket.
     * @param data the data to the OS
     */
    private static void write(String data) throws IOException {

        S = new socket(PORT, IP);
        S.connect(LClient.PORT, LClient.IP);
        S.write(data);
        S.close();

    }

}
