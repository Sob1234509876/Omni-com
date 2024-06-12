package vanilla.net;

import java.util.*;

import game.io.*;
import game.main.*;
import game.api.*;
import vanilla.utils.*;

//TODO: Load all gt in save. (3/6)
//TODO: Finish debug (3/6)
//TODO: Finish Info This command (For checking inventory). (3/6)
public class LServerCMDSolver extends Thread {

    private static String[] Cmd_Buffer;
    /**
     * <pre>
     * 0 : 
     * 1 : INFO xxx xxx xxx
     * 2 : DEBUG xxx xxx
     * </pre>
     */
    private static volatile int Mode;
    private static volatile int Cmd_Pointer;

    private static final String ETR_PAR_FRM = output.translate("vanilla.ParLftFrt");
    private static final String TOTAL_PAR_FRM = output.translate("vanilla.TotalParFrt");
    private static final String TIME = "TIME";
    private static final String INFO = "INFO";
    private static final String DEBUG = "DEBUG";
    // CMDS

    private static final int INFO_MODE = 1;
    private static final int DEBUG_MODE = 2;
    // The modes

    private static final int INFO_PAR_LEN = 3;
    private static final int DEBUG_PAR_LEN = 3;
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
                            AfterMath(new Date());

                        } else if (LServer.GOT_CMD.equals(INFO)) {
                            // Load the INFO command into the command buffer
                            InitLongCmd(INFO_MODE, INFO_PAR_LEN);

                        } else if (LServer.GOT_CMD.equals(DEBUG)) {
                            InitLongCmd(DEBUG_MODE, DEBUG_PAR_LEN);
                        }

                    } else if (Mode == INFO_MODE) {

                        if (Cmd_Pointer < INFO_PAR_LEN) {
                            // Loads arguments
                            LoadCmdArg();
                        } else if (Arrays.equals(Cmd_Buffer, Arrays.asList("THIS", " ", " ").toArray())) {
                            // Send back the users inventory.
                            AfterMath(
                                    String.format("[%s]%s\n[%s]%s\n[%s]%s\n",
                                            output.translate("vanilla.info.this.item"),
                                            Arrays.toString(vanilla.api.data.Items.getArray()),
                                            output.translate("vanilla.info.this.fluid"),
                                            Arrays.toString(vanilla.api.data.Fluids.getArray()),
                                            output.translate("vanilla.info.this.element"),
                                            Arrays.toString(vanilla.api.data.Elements.getArray())));
                        }

                        if (Arrays.equals(Cmd_Buffer, Arrays.asList("GAME", " ", " ").toArray())) {
                            // Sends back the data of the VM, such as loaded plugins and memory amount.
                            AfterMath(LServer.SEND_DATA = String.format("[%s]%s\n[%s]%s/%s",
                                    output.translate("vanilla.info.game.plug"),
                                    Arrays.toString(data.Plugins.toArray()),
                                    output.translate("vanilla.info.game.memory"),
                                    Main.DEF_RUNTIME.freeMemory(),
                                    Main.DEF_RUNTIME.totalMemory()));

                        }

                    } else if (Mode == DEBUG_MODE) {
                        // Access to item giving and etc.
                        if (Cmd_Pointer < DEBUG_PAR_LEN) {

                            LoadCmdArg();// Load arguments

                        } else if (Arrays.equals(Cmd_Buffer,
                                Arrays.asList("ITEM", Cmd_Buffer[1], Cmd_Buffer[2]).toArray())) {

                            search.SetInv(Cmd_Buffer[1], vanilla.api.data.Items, Long.parseLong(Cmd_Buffer[2]));

                            AfterMath();
                        }

                    }
                }

                Thread.sleep(100);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    /**
     * Inits parameter loading.
     * 
     * @param mode the mode of your command.
     * @param len  the parameter amount of your command.
     */
    private static void InitLongCmd(int mode, int len) {
        Cmd_Buffer = new String[len];
        Mode = mode;
        LServer.SEND_DATA = String.format(TOTAL_PAR_FRM, len);
        LServer.GOT_CMD = null;

    }

    /** Loads in the arguments */
    private static void LoadCmdArg() {
        Cmd_Buffer[Cmd_Pointer] = LServer.GOT_CMD;

        if (Cmd_Buffer.length - Cmd_Pointer != 1) {
            LServer.SEND_DATA = String.format(ETR_PAR_FRM, Cmd_Buffer.length - Cmd_Pointer - 1);
        } else {
            LServer.SEND_DATA = "Enter";
        }

        Cmd_Pointer++;
        LServer.GOT_CMD = null;
    }

    /**
     * Does the after-math after dealing with commands that does not return any
     * message.
     * 
     * @see {@link LServerCMDSolver#AfterMath(Object)}
     */
    private static void AfterMath() {
        AfterMath("...");
    }

    /**
     * 
     * Does the after-math after dealing with commands that does return a
     * message.
     * 
     * @param m
     */
    private static void AfterMath(Object m) {
        Mode = 0;
        Cmd_Pointer = 0;
        Cmd_Buffer = null;
        LServer.GOT_CMD = null;
        LServer.SEND_DATA = m.toString();
    }

    public LServerCMDSolver() {
        super.setName("Local Solver");
    }
}
