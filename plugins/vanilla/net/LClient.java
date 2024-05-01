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

    public static int           PORT;
    public static InetAddress   IP;

    public void run() {

        try {

            LInit();
            output.write(game.main.Main.LangSettings.getProperty("vanilla.EnterCMD"));

            while (true) {
                LClient.Buffer = input.GET();
                write(LClient.Buffer);
                output.log("Send cmd : " + LClient.Buffer);
                LClient.Buffer = read();
                output.log("Recv from server : " + LClient.Buffer);
                output.write(LClient.Buffer);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    private static void write(String data) throws IOException {
        S = new socket(PORT, IP);
        S.connect(LServer.PORT, LServer.IP);
        S.write(data);
        S.close();
    }

    private static String read() throws IOException {
        S = new socket(PORT, IP);
        LClient.Buffer = S.read();
        S.close();
        return LClient.Buffer;

    }

    private static void LInit() throws UnknownHostException {
        LClient.PORT = 9000;
        LClient.IP   = Inet6Address.getLoopbackAddress();
    }
}
