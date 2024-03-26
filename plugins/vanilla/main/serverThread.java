package vanilla.main;

import vanilla.utils.*;

import java.net.*;

/**
 * Currently used for testing
 */
public class serverThread implements Runnable {

    public static server SS;

    public void run() {

        try {

            SS = new server(8080, Inet6Address.getLocalHost());

            SS.start();
            System.out.println(SS.read());
            SS.write("OKAY, YAY!!!");

            SS.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
