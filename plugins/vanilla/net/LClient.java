package vanilla.net;

import vanilla.utils.*;

import java.io.IOException;
import java.net.*;

import game.io.*;

/**
 * Currently use for testing.
 * 
 * @version 1.1a
 * @since 1.2.0a
 */
public class LClient implements Runnable {

    public  static socket S;
    private static String Buffer;

    public static int         PORT;
    public static InetAddress IP;

    public void run() {

        output.log("CLIENT START");

        try {

            LInit();
            output.write(game.main.Main.LangSettings.getProperty("vanilla.EnterCMD"));

            while (true) {
                LClient.Buffer = input.GET();

                write(LClient.Buffer);
                LClient.Buffer = read();

                output.write(LClient.Buffer);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    private static void write(String data) throws IOException {
        S.connect(LServer.PORT, LServer.IP);
        S.write(data);
    }

    private static String read() throws IOException {
        LClient.Buffer = S.read();
        return LClient.Buffer;

    }

    private static void LInit() throws UnknownHostException, SocketException {
        LClient.PORT = 9000;
        LClient.IP   = Inet6Address.getLoopbackAddress();
        S = new socket(PORT, IP);
    }
}
