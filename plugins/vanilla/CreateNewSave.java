package vanilla;

import game.main.*;
import game.gui.listeners.KeyDetect;
import game.io.*;

import java.io.*;

public class CreateNewSave {

    public static void Create() throws Exception {
        
        output.write(Main.langSettings.getProperty("CreateSaveName"));

        File TFOLDER = new File(Main.SAVES_PATH, GET());
        TFOLDER.mkdir();

        File TF = new File(TFOLDER, "data");
        TF.createNewFile();

        Writer TW = new FileWriter(TF, Main.DEF_CHARSET);
        TW.write("META=null");
        TW.close();

        Play.Start(TF);

        output.write();
    }

    private static String GET() {
        while (KeyDetect.PressedKey != '\n') ;
        String tmp = input.read();
        input.clear();
        KeyDetect.PressedKey = '\0';

        return tmp;
    }
}
