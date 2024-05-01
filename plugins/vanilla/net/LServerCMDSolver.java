package vanilla.net;

import java.util.*;

import game.io.*;

public class LServerCMDSolver implements Runnable {
    
    private static final String TEST = "test";

    public void run() {
        try {
            
            while (true) {
                if (LServer.GOT_CMD != null && LServer.SEND_DATA == null) {

                    if (LServer.GOT_CMD.equals(TEST)) {
                        LServer.GOT_CMD = null;
                        LServer.SEND_DATA = new Date().toString();
                    }
                }

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }
}
