package top.sob.core.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import javax.swing.border.Border;

import top.sob.core.util;
import top.sob.core.api.meta;

/** Some basic graphical vars. */
public final class Graphic {

        public static final ImageIcon ICON = new ImageIcon(meta.THIS_CLASS_LOADER
                        .getResource("assets/icon.png"));

        public static final JFrame DEF_FRAME = new JFrame("Omni com | Terminal");
        public static final JFrame INFO_FRAME = new JFrame("Omni com | Info");
        public static final GInput INPUT = new GInput();
        public static final GOutput OUTPUT = new GOutput();
        public static final GInfo INFO = new GInfo();

        public static final int FRAME_HEIGHT = Integer.parseInt(util.getConfig("ui", "d", "height"));
        public static final int FRAME_WIDTH = Integer.parseInt(util.getConfig("ui", "d", "width"));

        public static final int FONT_SIZE = Integer.parseInt(util.getConfig("ui", "font", "size"));
        public static final String FONT_NAME = util.getConfig("ui", "font", "name");

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

        public static final Color DEF_BG_COLOR = new Color(Integer.parseInt(util.getConfig("ui", "color", "bg")),
                        false);
        public static final Color DEF_FG_COLOR = new Color(Integer.parseInt(util.getConfig("ui", "color", "fg")),
                        false);

        public static final Border DEF_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, DEF_FG_COLOR);

        static {
                DEF_FRAME.add(INPUT);
                DEF_FRAME.add(OUTPUT);
                INFO_FRAME.add(INFO);
        }

}
