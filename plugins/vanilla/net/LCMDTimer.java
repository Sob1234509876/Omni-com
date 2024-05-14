package vanilla.net;

import game.io.*;

public class LCMDTimer extends Thread {

    private static int TMP_FN;

    public void run() {

        try {

            output.log("STARTING!");

            while (true) {

                while (LServer.GOT_CMD == null)
                    Thread.sleep(50);
                TMP_FN = LServer.FLOW_NUMBER;
                Thread.sleep(1000);

                if (TMP_FN == LServer.FLOW_NUMBER && LServer.SEND_DATA == null) {
                    LServer.SEND_DATA = "Unkown";
                    LServer.GOT_CMD = null;
                }

            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    public LCMDTimer() {
        super.setName("Timer");
    }

}
