package vanilla.net;

import java.util.*;

import game.io.*;
import game.*;

public class LServerCMDSolver implements Runnable {
    
    private static String Buffer;

    private static final String TIME = "TIME";
    private static final String INFO = "INFO";

    public void run() {
        try {
            
            while (true) {
                if (LServer.GOT_CMD != null && LServer.SEND_DATA == null) {

                    LServer.GOT_CMD = LServer.GOT_CMD.toUpperCase();

                    if (LServer.GOT_CMD.equals(TIME)) {
                        LServer.GOT_CMD = null;
                        LServer.SEND_DATA = new Date().toString();
                    } else if (LServer.GOT_CMD.equals(INFO)) {
                        LServer.GOT_CMD = null;

                        Buffer = "Plugins :\n";
                        Iterator<String> i = data.Plugins.iterator();
                        while (i.hasNext()) {
                            Buffer += i.next() + "\n";
                        }

                        LServer.SEND_DATA = Buffer;

                    }
                }

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }
}
