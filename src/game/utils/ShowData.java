package game.utils;

import game.io.*;
import game.main.*;

public class ShowData extends Thread {

    public void run() {
        try {

            while (true) {
                output.log(String.format("FM : %d, TM : %d, MM : %d\nNext memory report in 120 seconds.",
                        Main.DEF_RUNTIME.freeMemory(),
                        Main.DEF_RUNTIME.totalMemory(),
                        Main.DEF_RUNTIME.maxMemory()));
                Thread.sleep(120000);
            }

        } catch (Exception e) {
            output.log(e);
        }
    }

    public ShowData() {
        super.setName("Data");
    }
}
