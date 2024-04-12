package src.io;

import src.main.Main;

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

}
