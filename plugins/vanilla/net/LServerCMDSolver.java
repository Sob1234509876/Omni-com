package vanilla.net;

public class LServerCMDSolver implements Runnable {
    
    private static final String TEST = "test";

    public void run() {
        try {
            
            while (true) {
                if (LServer.GOT_CMD != null && LServer.SEND_DATA == null) {

                    if (LServer.GOT_CMD.equals(TEST)) {
                        LServer.GOT_CMD = null;
                        LServer.SEND_DATA = "FINALLY!!!";
                    }
                }

                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }
}
