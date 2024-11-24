package top.sob.core;

import java.io.IOException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.lang.reflect.InvocationTargetException;

import java.net.URL;
import java.net.URI;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.jar.JarFile;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.plaf.metal.MetalLookAndFeel;

import org.apache.log4j.FileAppender;

import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Static;
import top.sob.core.api.Meta;

import top.sob.core.ui.Graphic;
import top.sob.core.ui.GInfo;

@Static
@Immutable
public final class Initializations {

    private static class IsFileFilter implements FileFilter {

        public boolean accept(File file) {
            return file.isFile();
        }
    }

    private Initializations() {
    }

    static void run0() throws IOException {

        final File SAVES = new File(Meta.SAVES_URI);
        final File[] PLUGS = new File[Meta.PLUGINS_URI.length];
        final File CONF = new File(Meta.CONFIGS_URI);
        final File REPOS = new File(Meta.REPORTS_URI);
        // Some folder files

        final File CORE_CFG = new File(CONF, "core.cfg");

        //noinspection ResultOfMethodCallIgnored
        SAVES.mkdirs();
        for (int i = 0; i < PLUGS.length; i++) {
            PLUGS[i] = new File(Meta.PLUGINS_URI[i]);
        }
        //noinspection ResultOfMethodCallIgnored
        Stream.of(PLUGS).forEach(File::mkdirs);
        //noinspection ResultOfMethodCallIgnored
        CONF.mkdirs();
        //noinspection ResultOfMethodCallIgnored
        REPOS.mkdirs();
        // Make folder

        if (!CORE_CFG.exists()) {
            Main.LOGGER.info("COPYING DEFAULT CONFIG");
            InputStream IS = Main.class
                    .getClassLoader()
                    .getResourceAsStream("assets/backup/core.cfg"); // Get stream
            OutputStream OS = new FileOutputStream(CORE_CFG);

            Objects.requireNonNull(IS);

            OS.write(IS.readAllBytes()); // < 1kb size, your computer could handle, right?
            OS.close();
        }
        // If this does not exist then copy a default config from the jar package.
    }

    static void run1() throws IOException {

        Main.LOGGER.debug(new File(Meta.REPORT_URI));

        var b = new File(Meta.REPORT_URI).createNewFile(); // Create file
        Main.LOGGER.addAppender(
                new FileAppender(
                        Utilities.DefLayout.getInstance(),
                        Meta.REPORT_URI.getPath())); // Add appender

        if (b) {
            Main.LOGGER.info("Report file created");
        }
    }

    static void run2() throws
            IOException,
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException {
        var Lst = new LinkedList<File>();

        for (URI file : Meta.PLUGINS_URI) {
            Lst.addAll(Arrays.asList(Objects.requireNonNull(new File(file).listFiles(new IsFileFilter()))));
        }

        var files = Lst.toArray(new File[0]); // Gets only the jar files.
        var urls = new LinkedList<URL>();
        var mainClasses = new LinkedList<String>();
        // Vars

        //// Get jar main class
        for (File file : files) {

            try (var jar = new JarFile(file)) {
                mainClasses.add(jar.getManifest()
                        .getMainAttributes()
                        .getValue("Main-Class")); // Get main class

                Main.LOGGER.debug(Utilities.getFileName(file) + " -> " + mainClasses.getLast());
            }

        }

        //// Get jar url
        for (File file : files) {
            urls.add(new URL(String.format("file:%s", file.toString())));
        }

        //// Load jars
        @SuppressWarnings("resource")
        URLClassLoader ucl = new URLClassLoader(urls.toArray(new URL[0])); // This will never be closed

        for (String string : mainClasses) {

            // Prevent NPE
            if (string == null) {
                continue;
            }

            Main.LOGGER.info(String.format("------ %s ------", string));
            ucl.loadClass(string)
                    .getMethod("main", String[].class)
                    .invoke(null, (Object[]) (new String[1])); // Invokes the main method
        }
        Main.LOGGER.info("------------");

    }

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
