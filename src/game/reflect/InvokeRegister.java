package game.reflect;

import java.lang.reflect.*;

import game.io.*;
import game.api.*;

public class InvokeRegister {

    public static void Load(Method[] MainMethods)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        output.log("Start registering GTs");
        for (Method method : MainMethods) {

            if (method.getAnnotation(Register.class) != null) {
                method.getDeclaringClass().getMethod("load");
            }
            // Load
        }
    }

}
