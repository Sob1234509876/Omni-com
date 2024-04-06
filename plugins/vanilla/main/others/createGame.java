package vanilla.main.others;

import src.gui.listeners.*;

import vanilla.io.*;
import vanilla.main.Main;
import vanilla.main.localClient;
import vanilla.main.localServer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * A runnable for creating games and entering the game. There is an "interface"
 * called {@code gameType}. What does it do? Just tells you what mode is the
 * user using, which
 * 
 * <pre>
 * -1 : NOT_INIT
 * 0 : SINGLE_PLAYER
 * 1 : MULTI_PLAYER (W.I.P)
 * 2 : TEST (W.I.P always)
 * </pre>
 * 
 * Nice block.
 * <p>
 * 
 * @version 1.0a
 * @since 1.2.0a
 */

public class createGame implements Runnable {

    private static final File SAVES_PATH = src.main.Main.SAVES_PATH;
    private static Thread SST = new Thread(new localServer(), "Server Thread"),
            ST = new Thread(new localClient(), "Client Thread");

    private static String buffer;

    public static long gameType = -1;

    public void run() {

        while (true) {

            // A buffer for saving time using the method
            buffer = GET();

            // Choose the save files to play, if there isn`t a save file then it will create
            // a new empty save file.
            if (buffer.equals("play")) {

                File f = SAVES_PATH;
                // If there is no save files then create one.
                if (f.list().length == 0) {

                    // Just flags, the real creating is in the createNewSave() method
                    src.io.output.log("CREATE FILE");
                    try {
                        createNewSave();
                    } catch (Exception e) {
                        e.printStackTrace();
                        e.printStackTrace(System.out);

                        output.write("Cannot create save file.");
                    }

                } else {

                    // Use for debugging
                    try {
                        createNewSave();
                    } catch (Exception e) {
                        e.printStackTrace();
                        e.printStackTrace(System.out);
                    }
                }
            }

        }
    }

    private static void createNewSave() throws Exception {

        // A flag.
        src.io.output.log("CREATE FILE2");

        // Asks the name of the new save
        output.write(Main.langSettings.getProperty("createSaveName"));

        buffer = GET();

        ///////////////////////////////////////////// A nice wall///////////////////
        // mkdir()
        Paths.get(
                SAVES_PATH.toString(),
                buffer).toFile().mkdir();

        // Write META
        OutputStream OS = new FileOutputStream(
                Paths.get(
                        SAVES_PATH.toString(),
                        buffer,
                        "DATA.dat")
                        .toString());

        OS.write("META:null".getBytes(Charset.forName("utf-8")));

        // Close it
        OS.close();
        ///////////////////////////////////////////// A nice wall///////////////////

        output.write("Created finish, entering game.");
        enterGame();

        ///////////////////////////////////////////// A nice wall///////////////////
    }

    private static void enterGame() throws Exception {

        src.io.output.log("STARTED LOCAL GAME SERVER AND CLIENT", "FLAG");

        SST.start();
        ST.start();
    }

    /**
     * Gets the String in the vanilla input box. It also waits for the user to press
     * enter. Will not impl. to the vanilla utils because it will be way too complex
     * e.x :
     * <p>
     * redirecting the reading "stream" to a new input box.
     * 
     * @return the String in the vanilla input box.
     */
    private static String GET() {
        while (keyDetect.PressedKey != '\n')
            ;
        String buf = input.read();
        input.clear();
        keyDetect.PressedKey = '\0';
        return buf;
    }

}
