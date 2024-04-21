package game.utils;

import game.io.*;

public class ShowData implements Runnable{
    
    public void run() {
        try {

            while (true) {
                output.log(String.format("FM : %d, TM : %d, MM : %d\nNext memory report in 120 seconds.",
                    Runtime.getRuntime().freeMemory(),
                    Runtime.getRuntime().totalMemory(),
                    Runtime.getRuntime().maxMemory()));
                Thread.sleep(120000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }
}