package game.io;

import game.main.*;
import game.gui.listeners.*;

/*
 * todo : change it to match the gui game
 */

public class input {

    public static String read() {
        return Main.InTextArea.getText();
    }

    public static void clear() {
        Main.InTextArea.setText(null);
    }
    
    // Change the way on how input gets things,
    // make it less resource taking.
    public static String GET() {
        while (KeyDetect.PressedKey != '\n') ;
        String tmp = input.read();
        input.clear();
        KeyDetect.PressedKey = '\0';

        return tmp;
    }

}
