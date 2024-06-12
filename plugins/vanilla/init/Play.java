package vanilla.init;

import java.io.*;

import vanilla.net.LClient;
import vanilla.net.LServer;

public class Play {

    public static final int CLIENT_MODE = 0;
    public static final int SERVER_MODE = 1;
    public static final int NORMAL = 2;
    public static final int HARD = 3;
    public static final int DEBUG = 4;
    public static final int REAL = 5;
    // Cons.

    public static int Mode;
    public static File GameFile;
    // Some type of API

    /** No instance constructing */
    private Play() {
    }

    /**
     * Starts a multi-player game.
     * There are 2 types of mode :
     * 
     * <pre>
     * CLIENT_MODE : the game is a client of a server.
     * SERVER_MODE : the game is a server.
     * </pre>
     * <hr>
     * <h1>WARNING</h1>
     * <p>
     * THIS PEICE OF CODE HAVEN`T BEEN USED,
     * <p>
     * IF YOU WANT TO USE IT PLEASE CONTACT
     * <p>
     * THE AUTHOR AND HELP THE AUTHOR ON
     * <p>
     * TESTING!
     * 
     * @param Mode the mode of the game.
     * @throws Exception
     */
    public static void Start(Integer Mode) throws Exception {

        Play.Mode = Mode;

        switch (Mode) {
            case CLIENT_MODE:

                new LClient().start();
                break;

            case SERVER_MODE:

                InitGameResource.Load();
                new LServer().start();
                break;
        }
    }

    /**
     * Starts a single-player game.
     * There are 4 types of mode :
     * 
     * <pre>
     * NORMAL : normal mode.
     * HARD   : hard mode.
     * DEBUG  : debug (dev only).
     * REAL   : too much realism.
     * </pre>
     * 
     * @param Game the game file.
     * @param Mode the mode of the game.
     * @throws Exception
     */
    public static void Start(File Game, Integer Mode) throws Exception {
        InitGameResource.Load();

        Play.Mode = Mode;
        Play.GameFile = new File(Game, "data");

        LoadSave.Load();

        new LServer().start();
        new LClient().start();

    }
}
