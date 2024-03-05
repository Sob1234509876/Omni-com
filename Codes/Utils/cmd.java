package Codes.Utils;

import java.io.InputStream;

public class cmd {

    public static void noOutCmd(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
        }

    }

    public static void hasOutCmd(String cmd) {

        char buf = 0;
        String t = new String();

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            InputStream OS = p.getInputStream();
            p.waitFor();
            while (buf != -1) {

                buf = (char) OS.read();
                t += buf;

            }
            p.destroy();

            System.out.println(t);

        } catch (Exception e) {
        }

    }

}
