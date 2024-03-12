package src.utils;

import src.main.Main;

/*
 * todo : change it to match the gui game
 */

public class input {

    public static int intInput() {

        return Integer.parseInt(Main.in.getText());

    }

    public static boolean boolInput() {

        return Main.in.getText().equals("y") || Main.in.getText().equals("Y");

    }

    public static String Input() {

        return Main.in.getText();

    }

}
