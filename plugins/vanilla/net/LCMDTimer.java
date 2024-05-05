package vanilla.net;

import game.io.*;

public class LCMDTimer implements Runnable {
    
    private static volatile String TMP_CMD;

    public void run() {
        try {
            while (true) {

                while (LServer.GOT_CMD == null) Thread.sleep(50);
                TMP_CMD = LServer.GOT_CMD;
                Thread.sleep(1000);
                output.log("CHECK");
    
                if (TMP_CMD != null && LServer.GOT_CMD != null) {
                    // Null Pointer prevention
                    if (LServer.GOT_CMD.equals(TMP_CMD)) {
                        LServer.GOT_CMD = null;
                        LServer.SEND_DATA = "";
                        TMP_CMD = null;
                    }
                    
                }
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

}
