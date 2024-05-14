package vanilla.net;

import java.util.*;

import game.io.*;
import game.*;

public class LServerCMDSolver extends Thread {

    private static String[] Cmd_Buffer;
    /**
     * <pre>
     * 0 : INFO xxx xxx xxx
     * </pre>
     */
    private static int Mode;
    private static int Cmd_Pointer;

    private static final String ETR_PAR_FRM = output.translate("vanilla.ParLftFrt");
    private static final String TIME = "TIME";
    private static final String INFO = "INFO";
    // CMDS

    private static final int INFO_MODE = 1;
    // The modes

    private static final int INFO_PAR_LEN = 3;
    // Parameter lengths

    public void run() {

        try {

            while (true) {
                if (LServer.GOT_CMD != null && LServer.SEND_DATA == null) {

                    LServer.GOT_CMD = LServer.GOT_CMD.toUpperCase();
                    // Formatting

                    if (Mode == 0) {
                        // Means there is currently no mode parameter entering

                        if (LServer.GOT_CMD.equals(TIME)) {
                            // Get time command
                            LServer.SEND_DATA = new Date().toString();
                            LServer.GOT_CMD = null;

                        } else if (LServer.GOT_CMD.equals(INFO)) {
                            // Load the INFO command into the command buffer
                            Cmd_Buffer = new String[INFO_PAR_LEN];
                            Mode = INFO_MODE;
                            Cmd_Pointer = 0;
                            LServer.SEND_DATA = String.format(ETR_PAR_FRM, 3);
                            LServer.GOT_CMD = null;
                        }

                    } else if (Mode == INFO_MODE) {

                        if (Cmd_Pointer < INFO_PAR_LEN) {
                            Cmd_Buffer[Cmd_Pointer] = LServer.GOT_CMD;
                            LServer.SEND_DATA = String.format(ETR_PAR_FRM, INFO_PAR_LEN - Cmd_Pointer++);
                            LServer.GOT_CMD = null;
                        }

                        if (Cmd_Buffer[0].equals("GAME")) {
                            LServer.SEND_DATA = String.format("[%s]%s\n[%s]%s/%s",
                                    output.translate("vanilla.info.game.plug"),
                                    Arrays.toString(data.Plugins.toArray()),
                                    output.translate("vanilla.info.game.memory"),
                                    Runtime.getRuntime().freeMemory(),
                                    Runtime.getRuntime().totalMemory());
                            Mode = 0;
                            Cmd_Buffer = null;
                            LServer.GOT_CMD = null;
                        }

                    }
                }

                Thread.sleep(100);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    public LServerCMDSolver() {
        super.setName("Local Solver");
    }
}
