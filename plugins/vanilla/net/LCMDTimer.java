package vanilla.net;

import game.io.*;

public class LCMDTimer implements Runnable {
    
    public void run() {
        try {
            while (LServer.GOT_CMD == null);
            Thread.sleep(1000);
            LServer.GOT_CMD = null;
            LServer.SEND_DATA = "?";
        } catch (Exception e) {
            output.log(e);
        }
    }

}
