package game.io;

import game.main.*;
import game.ui.listeners.*;

public class input {

    /** No instance constructing */
    private input() {
    }

    public static String read() {
        return Main.InTextArea.getText();
    }

    public static void clear() {
        Main.InTextArea.setText("");
    }

    public static String GET() {

        while (KeyDetect.PressedKey != '\n')
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        ;
        String tmp = input.read();
        input.clear();
        KeyDetect.PressedKey = '\0';

        if (tmp.equals("")) {
            return " ";
        } else {
            return tmp;
        }
    }

}
