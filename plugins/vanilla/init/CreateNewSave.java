package vanilla.init;

import game.main.*;
import game.ui.listeners.KeyDetect;
import game.io.*;

import java.io.*;

/**
 * <h1>New Save</h1>
 * Creates a new save, the new save looks like this:
 * 
 * <pre>
 * META:null
 * </pre>
 * 
 * That is everything in it.
 * <hr>
 * <h1>Saving Format</h1>
 * With a new save like this :
 * 
 * <pre>
 * demo.item.a:1,1
 * demo.item.b:1,2
 * demo.machine.c:114,514
 * </pre>
 * 
 * It means the player has 1 whole and 1 fraction (which the factor can be any
 * number) of the item {@code a},
 * 1 whole and 2 fractions of the item {@code b} and 114 whole and 514 fractions
 * of the machine {@code c} in
 * the plugin {@code demo}.
 * <p>
 * The vanilla plugin uses {@code java.util.Properties} for getting the data in
 * the save.
 */
public class CreateNewSave {

    /**No instance constructing */
    private CreateNewSave() {}

    public static void Create() throws Exception {

        output.write(output.translate("CreateSaveName"));

        File TFOLDER = new File(Main.SAVES_PATH, GET());
        TFOLDER.mkdir();

        File TF = new File(TFOLDER, "data");
        TF.createNewFile();

        Writer TW = new FileWriter(TF, Main.DEF_CHARSET);
        TW.write("META=null");
        TW.close();

        Play.Start(TF, 0);

        output.write();
    }

    private static String GET() {
        while (KeyDetect.PressedKey != '\n')
            ;
        String tmp = input.read();
        input.clear();
        KeyDetect.PressedKey = '\0';

        return tmp;
    }
}
