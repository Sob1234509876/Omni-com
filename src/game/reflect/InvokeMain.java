package game.reflect;

import game.api.*;
import game.io.*;

import java.lang.reflect.*;

public class InvokeMain {

    /**
     * Invokes the main method of a plugin. 
     * 
     * @param MainMethods the array of main methods from different plugins.
     * @throws IllegalAccessException    {@link Method#invoke(Object, Object...)}
     * @throws InvocationTargetException {@link Method#invoke(Object, Object...)}
     */
    public static void Load(Method[] MainMethods) throws IllegalAccessException, InvocationTargetException {

        String NameOfClass;

        output.log("Start running plugins");
        for (Method method : MainMethods) {
            NameOfClass = method.getName().split("\\.")[0];
            output.log("---" + NameOfClass + "---");

            method.invoke(null, new Object[1]);
            // Load class (Example.Main.main(String[]))

            data.Plugins.add(NameOfClass);
        }
        output.log("----------------");
        // Load
        /*
         * What you should suspect after running the code:
         * ---Example---
         * Example plugin!
         * ---Example2---
         * Second example!
         * ----------------
         */
    }
}
