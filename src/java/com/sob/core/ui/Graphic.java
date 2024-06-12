package com.sob.core.ui;

import java.awt.*;

import javax.swing.*;

import com.sob.core.*;
import com.sob.core.api.*;

public final class Graphic {

        public static final ImageIcon ICON = new ImageIcon(meta.THIS_CLASS_LOADER
                        .getResource("assets/icon.png"));

        public static final JFrame FRAME = new JFrame("Omni com");
        public static final GInput INPUT = new GInput();
        public static final GOutput OUTPUT = new GOutput();

        public static final int FRAME_HEIGHT = Integer.parseInt(util.GetConfig("ui", "d", "height"));
        public static final int FRAME_WIDTH = Integer.parseInt(util.GetConfig("ui", "d", "width"));

        public static final int FONT_SIZE = Integer.parseInt(util.GetConfig("ui", "font", "size"));
        public static final String FONT_NAME = util.GetConfig("ui", "font", "name");

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

        static {
                FRAME.add(INPUT);
                FRAME.add(OUTPUT);
        }

}
