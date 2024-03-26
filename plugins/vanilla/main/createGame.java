package vanilla.main;

import src.gui.listeners.*;

import vanilla.io.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class createGame implements Runnable {

    private static final Path SAVES_PATH = src.main.Main.SAVES_PATH;
    private static Thread SST = new Thread(new clientThread(), "ST"),
            ST = new Thread(new serverThread(), "SST");

    private String buffer;

    public void run() {

        while (true) {

            if (keyDetect.PressedKey == '\n') {

                buffer = vanilla.io.input.read();

                // Choose the save files to play, if there isn`t a save file then it will create
                // a new empty save file.
                if (buffer.equals("play")) {

                    File f = SAVES_PATH.toFile();
                    // If there is no save files then create one.
                    if (f.list().length == 0) {

                        // Just flags, the real creating is in the createNewSave() method
                        src.io.output.log("CREATE FILE", "FLAG");
                        try {
                            createNewSave();
                        } catch (Exception e) {
                            e.printStackTrace();
                            output.write("Cannot create save file.");
                        }

                    } else {
                        try {
                            createNewSave();
                        } catch (Exception e) {
                        }
                    }
                }

                keyDetect.PressedKey = '\0';
                input.clear();

            }
        }
    }

    public static void createNewSave() throws Exception {

        // A flag.
        src.io.output.log("CREATE FILE2", "FLAG");

        // Asks the name of the new save
        input.clear();
        output.write(Main.langSettings.getProperty("createSaveName"));

        while (keyDetect.PressedKey != '\n') {
            // Just wait for the user to enter the name.
        }

        ///////////////////////////////////////////// A nice wall///////////////////
        // mkdir()
        Paths.get(
                SAVES_PATH.toString(),
                input.read()).toFile().mkdir();

        // Write META
        OutputStream OS = new FileOutputStream(
                Paths.get(
                        SAVES_PATH.toString(),
                        input.read(),
                        "DATA.dat")
                        .toString());

        OS.write("META:null".getBytes(Charset.forName("utf-8")));

        // Close it and clean garbage
        OS.close();
        ///////////////////////////////////////////// A nice wall///////////////////

        output.write("Created finish, entering game.");
        enterGame();

        ///////////////////////////////////////////// A nice wall///////////////////
    }

    public static void enterGame() throws Exception {

        src.io.output.log("FLLAG", "FLAG");

        SST.start();
        ST.start();
    }

}
