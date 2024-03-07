package src.utils;

import java.io.BufferedInputStream;
import java.io.IOException;

/*
 * todo : change it to match the gui game
 */

public class input {
    public static int intInput(String ask) {
        System.out.print(ask);
        String t = new String();
        BufferedInputStream IS = new BufferedInputStream(System.in);
        char buf = 0;
        try {

            while (buf != -1) {
                buf = (char) IS.read();
                t += buf;
            }

        } catch (IOException e) {
        }

        return Integer.parseInt(t);

    }
}
