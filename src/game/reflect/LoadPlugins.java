package game.reflect;

import game.main.*;
import game.api.*;
import game.io.*;

//Tools
import java.util.jar.*;
import java.net.*;

//io
import java.io.*;
import java.lang.reflect.*;

public class LoadPlugins {

    /**
     * Loads in plugins main class, and also it`s registery class if it adds a
     * {@link Register} annotation to the class. Throws tons of reflective
     * exceptions.
     * <p>
     * Here is an example of loading in plugins, we create a plugin named
     * "Example" that has a directory of tree below
     * 
     * <pre>
     * >.
     * +->Example
     *    +->main
     *       +->Main.class
     *    +->lib
     *       +->...
     *    +->reg
     *       +->Reg.class
     * +->META-INF
     *    +->MANIFEST.MF
     * </pre>
     * 
     * The manifest file is like this below
     * 
     * <pre>
     * >Main-Class:Example.main.Main
     * ...:...
     * </pre>
     * 
     * The main function part of the plugin is like this below
     * 
     * <pre>
     * >@Register(RegClass = Example.reg.Reg.class)
     * public static void main(String[] args) {
     *     ...;
     * }
     * </pre>
     * 
     * Then when loading the plugin, it will first load {@code Example.reg.Reg} and
     * invokes its method {@code Load()}. Then, it will invoke {@ code
     * Example.main.Main}`s main method ({@code main(String[] args)}).
     * 
     * @throws IOException               {@link JarFile#JarFile(File)}
     * @throws ClassNotFoundException    {@link ClassLoader#loadClass(String)}
     * @throws NoSuchMethodException     {@link Class#getMethod(String, Class...)}
     * @throws IllegalAccessException    {@link Method#invoke(Object, Object...)}
     * @throws InvocationTargetException {@link Method#invoke(Object, Object...)}
     */
    public static void Load()
            throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException,
            InvocationTargetException {

        output.log("Start loading plugins");

        File[] plugins = Main.PLUGINS_PATH.listFiles(new FileFilter() {
            public boolean accept(File f) {
                return f.isFile();
            }
        });
        // Only allows files not dirs

        JarFile[] Jars = new JarFile[plugins.length];

        for (int i = 0; i < Jars.length; i++) {
            Jars[i] = new JarFile(plugins[i]);
        }

        String[] MainClasses = new String[plugins.length];

        for (int i = 0; i < Jars.length; i++) {
            MainClasses[i] = Jars[i].getManifest()
                    .getMainAttributes()
                    .getValue("Main-Class");
        }
        // This is going to be changed in the future

        URL[] URLS = new URL[plugins.length];

        for (int i = 0; i < URLS.length; i++) {
            URLS[i] = new URL("file:" + plugins[i].toString());
        }
        // Get URLS

        URLClassLoader UCL = new URLClassLoader(URLS);

        Method[] MainMethods = new Method[plugins.length];
        for (int i = 0; i < plugins.length; i++) {
            MainMethods[i] = UCL.loadClass(MainClasses[i])
                    .getMethod("main", String[].class);
        }
        // Get main methods

        UCL.close();

        InvokeRegister.Load(MainMethods);
        InvokeMain.Load(MainMethods);

    }
}
