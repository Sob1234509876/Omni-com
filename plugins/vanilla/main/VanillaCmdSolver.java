package vanilla.main;

import java.util.*;
import java.io.*;

import game.io.*;

public class VanillaCmdSolver implements Runnable {

    public static final Properties Settings     = game.main.Main.Settings;
    public static final Properties LangSettings = game.main.Main.LangSettings;

    private String buffer;

    private static final String CNS  = "cns";
    private static final String HELP = "help";
    private static final String PLAY = "play";

    public void run() {

        try {
            while (true) {
                buffer = input.GET();

                if (buffer.equals(CNS)) {
                    // Creates a new save
                    output.log("CNS");

                    Main.THIS_CLASS_LOADER.loadClass("vanilla.init.CreateNewSave")
                        .getMethod("Create")
                        .invoke(null);

                } else if (buffer.equals(PLAY)) {
                    // Play the game with a specific game file 
                    output.write(LangSettings.getProperty("vanilla.GetSave"));
                    buffer = input.GET();
                    output.write();

                    Main.THIS_CLASS_LOADER.loadClass("vanilla.init.Play")
                        .getMethod("Start", File.class, Integer.class)
                        .invoke(null, new File(buffer), 2);

                } else if (buffer.equals(HELP)) {
                    // Help (WIP)
                    output.write(LangSettings.getProperty("Help"));
                }
            }
        } catch (Exception e) {
            output.log(e);
        }
    }


}
