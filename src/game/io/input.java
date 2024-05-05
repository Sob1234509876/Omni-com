package game.io;

import game.main.*;
import game.gui.listeners.*;

public class input {

    public static String read() {
        return Main.InTextArea.getText();
    }

    public static void clear() {
        Main.InTextArea.setText(null);
    }
    public static String GET() {
        while (KeyDetect.PressedKey != '\n') try { Thread.sleep(50); } catch (InterruptedException e) {};
        String tmp = input.read();
        input.clear();
        KeyDetect.PressedKey = '\0';

        return tmp;
    }

}
