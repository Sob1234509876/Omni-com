package top.sob.core.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import top.sob.core.*;
import top.sob.core.api.*;

/** Some basic graphical vars. */
public final class Graphic {

        public static final ImageIcon ICON = new ImageIcon(meta.THIS_CLASS_LOADER
                        .getResource("assets/icon.png"));

        public static final JFrame FRAME = new JFrame("Omni com");
        public static final GInput INPUT = new GInput();
        public static final GOutput OUTPUT = new GOutput();

        public static final int FRAME_HEIGHT = Integer.parseInt(util.getProperty("ui", "d", "height"));
        public static final int FRAME_WIDTH = Integer.parseInt(util.getProperty("ui", "d", "width"));

        public static final int FONT_SIZE = Integer.parseInt(util.getProperty("ui", "font", "size"));
        public static final String FONT_NAME = util.getProperty("ui", "font", "name");

        public static final Font PLAIN_FONT = new Font(
                        FONT_NAME,
                        Font.PLAIN,
                        FONT_SIZE);

        public static final Font BOLD_FONT = new Font(
                        FONT_NAME,
                        Font.BOLD,
                        FONT_SIZE);

        public static final Font ITALIC_FONT = new Font(
                        FONT_NAME,
                        Font.ITALIC,
                        FONT_SIZE);

        public static final Color DEF_BG_COLOR = new Color(Integer.parseInt(util.getProperty("ui", "color", "bg")),
                        false);
        public static final Color DEF_FG_COLOR = new Color(Integer.parseInt(util.getProperty("ui", "color", "fg")),
                        false);

        public static final Border DEF_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, DEF_FG_COLOR);

        static {
                FRAME.add(INPUT);
                FRAME.add(OUTPUT);
        }

}
