package vanilla.init;

import java.io.*;

public class Play {

    public static final int CLIENT_MODE = 0;
    public static final int SERVER_MODE = 1;
    public static final int NORMAL      = 2;
    public static final int HARD        = 3;
    public static final int DEBUG       = 4;
    public static final int REAL        = 5;
    // Cons.

    private static Class<?> CLIENT_CLASS;
    private static Class<?> SERVER_CLASS;

    private static Thread CLIENT_THREAD;
    private static Thread SERVER_THREAD;
    // Threads, it could be done another way to save stack mem. but it will be a bit messy.
    // Oh no, ClassNotDefError is here again, last sight : vanilla.main.Main

    public static int  Mode;
    public static File GameFile;
    // Some type of API

    /**
     * Starts a multi-player game.
     * There are 2 types of mode :
     * <pre>
     * CLIENT_MODE : the game is a client of a server.
     * SERVER_MODE : the game is a server.
     * </pre>
     * <hr>
     * <h1>WARNING</h1>
     * <p>
     * THIS PEICE OF CODE HAVEN`T BEEN USED,
     * <p>
     * IF YOU WANT TO USE IT PLEASE CONTACT <p>
     * THE AUTHOR AND HELP THE AUTHOR ON
     * <p>
     * TESTING!
     * 
     * @param Mode the mode of the game.
     * @throws Exception
     */
    public static void Start(Integer Mode) throws Exception {
        
        init();
        Play.Mode = Mode;

        switch (Mode) {
            case CLIENT_MODE:

                CLIENT_THREAD.start();
                break;
        
            case SERVER_MODE:

                InitGameResource.Init();
                SERVER_THREAD.start();
                break;
        }
    }

    /**
     * Starts a single-player game.
     * There are 4 types of mode :
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
        init();
        InitGameResource.Init();

        Play.Mode     = Mode;
        Play.GameFile = Game;

        SERVER_THREAD.start();
        CLIENT_THREAD.start();

    }

    public static void init() throws Exception {

        SERVER_CLASS = vanilla.main.Main.THIS_CLASS_LOADER.loadClass("vanilla.net.LServer");
        CLIENT_CLASS = vanilla.main.Main.THIS_CLASS_LOADER.loadClass("vanilla.net.LClient");

        SERVER_THREAD = new Thread(new Runnable() {public void run() {try {SERVER_CLASS.getMethod("run").invoke(SERVER_CLASS.getConstructor().newInstance());} catch (Exception e) {e.printStackTrace();e.printStackTrace(System.out);}}}, "server");
        CLIENT_THREAD = new Thread(new Runnable() {public void run() {try {CLIENT_CLASS.getMethod("run").invoke(CLIENT_CLASS.getConstructor().newInstance());} catch (Exception e) {e.printStackTrace();e.printStackTrace(System.out);}}}, "client");

        SERVER_THREAD.setDaemon(true);
        // I`m sorry but I have used everything that I know.
        // Class not define error is an absolute killer to me.

    }
}
