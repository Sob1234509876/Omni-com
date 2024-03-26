package vanilla.main;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently used for testing.
 */
public class clientThread implements Runnable {

    public static client S;

    public void run() {

        try {
            S = new client(8080, Inet6Address.getLocalHost());

            S.write("LET`S CELEBRATE THAT THE CLIENT WORKS!");

            System.out.println(S.read());

            S.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
