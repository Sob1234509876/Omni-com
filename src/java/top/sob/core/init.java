package top.sob.core;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.Arrays;
import java.util.jar.*;

import javax.swing.*;
import javax.swing.plaf.metal.*;

import org.apache.log4j.*;

import top.sob.core.api.*;
import top.sob.core.ui.*;

/**
 * Packaged methods for game core init.
 */
public final class init {

    /** A file filter that accepts files and not directories */
    private static class IsFileFilter implements FileFilter {

        public boolean accept(File file) {
            return file.isFile();
        }
    }

    /** No instance making */
    private init() {
    }

    /**
     * No, you can`t run it outside the core of the game.
     * Creating folders and stuff, checks does it need to add
     */
    static void run0() throws IOException, ClassNotFoundException {

        Main.LOGGER.debug(Main.optSet);

        // Class.forName("top.sob.core.api.meta");

        final File SAVES = new File(meta.SAVES_URI);
        final File PLUGS = new File(meta.PLUGINS_URI);
        final File CONFS = new File(meta.CONFIGS_URI);
        final File REPOS = new File(meta.REPORTS_URI);
        // Some folder files

        final File CORE_CFG = new File(CONFS, "core.cfg");

        SAVES.mkdir();
        PLUGS.mkdir();
        CONFS.mkdir();
        REPOS.mkdir();
        // Make folder

        if (!CORE_CFG.exists()) {
            Main.LOGGER.info("COPYING DEFAULT CONFIG");
            InputStream IS = Main.class
                    .getClassLoader()
                    .getResourceAsStream("assets/backup/core.cfg"); // Get stream
            OutputStream OS = new FileOutputStream(CORE_CFG);
            OS.write(IS.readAllBytes()); // < 1kb size, your computer could handle, right?
            OS.close();
        }
        // If this doesn`t exists then copy a default config from the jar package.
    }

    /**
     * No, you can`t run it outside the core of the game.
     * Inits the report file.
     */
    static void run1() throws IOException {
        new File(meta.REPORT_URI.getPath()).createNewFile(); // Create file
        Main.LOGGER.addAppender(new FileAppender(new SimpleLayout(), meta.REPORT_URI.getPath())); // Add apender
    }

    /**
     * No, you can`t run it outside the core of the game.
     * Inits the plugins.
     */
    static void run2() throws MalformedURLException,
            IOException,
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        File[] files = new File(meta.PLUGINS_URI.getPath()).listFiles(new IsFileFilter()); // Gets only the iles
        JarFile[] jars = new JarFile[files.length];
        String[] mainClasses = new String[files.length];
        URL[] urls = new URL[files.length];
        URLClassLoader ucl;
        // Vars

        Main.LOGGER.debug(Arrays.toString(urls)); // Know where the urls are

        //// Get jar main class
        for (int i = 0; i < files.length; i++) {
            jars[i] = new JarFile(files[i]); // Get new jars
            mainClasses[i] = jars[i].getManifest()
                    .getMainAttributes()
                    .getValue("Main-Class"); // Get main class
            Main.LOGGER.debug(jars[i].getName() + " -> " + mainClasses[i]);
        }

        //// Get jar url
        for (int i = 0; i < files.length; i++) {
            urls[i] = new URL(String.format("file:%s", files[i].toString()));
            Main.LOGGER.info(urls[i]);
        }

        //// Load jars
        ucl = new URLClassLoader(urls);
        for (String string : mainClasses) {

            // Prevent NPE
            if (ucl == null) {
                continue;
            }

            Main.LOGGER.info(String.format("------ %s ------", string));
            ucl.loadClass(string)
                    .getMethod("main", String[].class)
                    .invoke(null, (Object[]) (new String[1])); // Invokes the main method
        }
        Main.LOGGER.info("------------");

        ucl.close();
    }

    /**
     * No, you can`t run it outside the core of the game.
     * Inits the ui.
     */
    static void run3() throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new MetalLookAndFeel()); // Unthinkable long names

        Graphic.FRAME.setSize(
                Graphic.FRAME_WIDTH,
                Graphic.FRAME_HEIGHT + 36);
        Graphic.FRAME.setResizable(false);
        Graphic.FRAME.setIconImage(Graphic.ICON.getImage());
        Graphic.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphic.FRAME.setLayout(null);
        Graphic.FRAME.setVisible(true);

        Graphic.INPUT.setBounds(0,
                Graphic.FRAME_HEIGHT - Graphic.FONT_SIZE,
                Graphic.FRAME_WIDTH,
                Graphic.FONT_SIZE);

        Graphic.OUTPUT.setBounds(0,
                0,
                Graphic.FRAME_WIDTH,
                Graphic.FRAME_HEIGHT - Graphic.FONT_SIZE);
    }

}
