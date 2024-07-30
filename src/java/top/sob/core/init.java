package top.sob.core;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
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
     * Creating folders and stuff, checks does it need to add
     */
    static void run0() throws IOException, ClassNotFoundException {

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
     * Inits the report file.
     */
    static void run1() throws IOException {
        new File(meta.REPORT_URI.getPath()).createNewFile(); // Create file
        Main.LOGGER.addAppender(
                new FileAppender(
                        new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN),
                        meta.REPORT_URI.getPath())); // Add appender
    }

    /**
     * Inits the plugins.
     */
    static void run2() throws MalformedURLException,
            IOException,
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        File[] files = new File(meta.PLUGINS_URI.getPath()).listFiles(new IsFileFilter()); // Gets only the jar files.
        JarFile[] jars = new JarFile[files.length];
        String[] mainClasses = new String[files.length];
        URL[] urls = new URL[files.length];
        // Vars

        //// Get jar main class
        for (int i = 0; i < files.length; i++) {
            jars[i] = new JarFile(files[i]); // Get new jars
            mainClasses[i] = jars[i].getManifest()
                    .getMainAttributes()
                    .getValue("Main-Class"); // Get main class
            Main.LOGGER.debug(util.getFileName(files[i]) + " -> " + mainClasses[i]);
        }

        //// Get jar url
        for (int i = 0; i < files.length; i++) {
            urls[i] = new URL(String.format("file:%s", files[i].toString()));
        }

        //// Load jars
        @SuppressWarnings("resource")
        URLClassLoader ucl = new URLClassLoader(urls); // This will never be closed

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

        // I have thought this for a whole hour
        // the price is to cause memory leak.
        // Ten minutes later, determination
        // tells me for the sake of the app,
        // I`ll need to do a sacrifise. The
        // sacrifise is:

        // ucl.close();

        // Advices:
        // Don`t add heavy plugins, light ones
        // won`t take too much memory. (The
        // light means there are small amount of
        // classes)

    }

    /**
     * Inits the ui.
     */
    static void run3() throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new MetalLookAndFeel()); // Long names

        Graphic.DEF_FRAME.setSize(
                Graphic.FRAME_WIDTH,
                Graphic.FRAME_HEIGHT + 36);
        Graphic.DEF_FRAME.setResizable(false);
        Graphic.DEF_FRAME.setIconImage(Graphic.ICON.getImage());
        Graphic.DEF_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphic.DEF_FRAME.setLayout(null);
        Graphic.DEF_FRAME.setVisible(true);

        Graphic.INFO_FRAME.setSize(
                GInfo.DEF_WIDTH,
                GInfo.DEF_HEIGHT + 36);
        Graphic.INFO_FRAME.setResizable(false);
        Graphic.INFO_FRAME.setIconImage(Graphic.ICON.getImage());
        Graphic.INFO_FRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Graphic.INFO_FRAME.setLayout(null);

        Graphic.INPUT.setBounds(0,
                Graphic.FRAME_HEIGHT - Graphic.FONT_SIZE,
                Graphic.FRAME_WIDTH,
                Graphic.FONT_SIZE);
        Graphic.INPUT.setBackground(Graphic.DEF_BG_COLOR);
        Graphic.INPUT.setForeground(Graphic.DEF_FG_COLOR);
        Graphic.INPUT.setBorder(Graphic.DEF_BORDER);

        Graphic.OUTPUT.setBounds(0,
                0,
                Graphic.FRAME_WIDTH,
                Graphic.FRAME_HEIGHT - Graphic.FONT_SIZE);
        Graphic.OUTPUT.setBackground(Graphic.DEF_BG_COLOR);
        Graphic.OUTPUT.setForeground(Graphic.DEF_FG_COLOR);
        Graphic.OUTPUT.setBorder(Graphic.DEF_BORDER);

        Graphic.INFO.getLeftPageButton().setBackground(Graphic.DEF_BG_COLOR);
        Graphic.INFO.getPageText().setBackground(Graphic.DEF_BG_COLOR);
        Graphic.INFO.getRightPageButton().setBackground(Graphic.DEF_BG_COLOR);
        Graphic.INFO.getLeftPageButton().setForeground(Graphic.DEF_FG_COLOR);
        Graphic.INFO.getPageText().setForeground(Graphic.DEF_FG_COLOR);
        Graphic.INFO.getRightPageButton().setForeground(Graphic.DEF_FG_COLOR);

        Graphic.INFO.getContentPanel().setBackground(Graphic.DEF_BG_COLOR);
        Graphic.INFO.getContentPanel().setForeground(Graphic.DEF_FG_COLOR);

        // Graphic.INFO_FRAME.setVisible(true);

    }

}
