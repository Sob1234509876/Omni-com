package vanilla.main;

import java.util.*;
import java.io.*;

import game.io.*;
import vanilla.init.CreateNewSave;
import vanilla.init.Play;

public class VanillaCmdSolver extends Thread {

    public static final Properties Settings = game.main.Main.Settings;

    private String buffer;

    private static final String CNS = "cns";
    private static final String HELP = "help";
    private static final String PLAY = "play";

    public void run() {

        try {
            while (true) {
                buffer = input.GET();

                if (buffer.equals(CNS)) {
                    // Creates a new save
                    output.log("CNS");

                    CreateNewSave.Create();

                    // Kills this thread
                    // Pro. :
                    // Makes the game cmd recieve more stable
                    // Con. :
                    // To change the current playing game folder, you need to reload the game.
                    break;

                } else if (buffer.equals(PLAY)) {
                    // Play the game with a specific game file
                    output.write(output.translate("vanilla.GetSave"));
                    buffer = input.GET();
                    output.write();

                    Play.Start(new File(buffer), 2);

                    // Kills this thread
                    // Pro. :
                    // Makes the game cmd recieve more stable
                    // Con. :
                    // To change the current playing game folder, you need to reload the game.
                    break;

                } else if (buffer.equals(HELP)) {
                    // Help (WIP)
                    output.write(output.translate("Help"));
                } else {
                    output.write("?");
                }
            }
        } catch (Exception e) {
            output.log(e);
        }
    }

    public VanillaCmdSolver() {
        super.setName("VCL");
    }

}
