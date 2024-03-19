package src.utils.io;

import src.main.Main;

/*
 * todo : change it to match the gui game
 */

public class input {

    public static String read() {
        return Main.in.getText();
    }

    public static void clear() {
        Main.in.setText("");
    }

}
