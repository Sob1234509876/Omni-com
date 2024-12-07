package top.sob.vanilla.ui;

import top.sob.core.ui.GOutput;
import top.sob.core.utils.io.swing.SwingPrintWriter;
import top.sob.vanilla.utils.TranslationUtils;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public final class Graphic {

    private Graphic() {
    }

    public static final GOutput INFO_TEXT = new GOutput();
    public static final GImg PIC_COMP = new GImg();
    public static final JFrame IMG_FRAME = new JFrame(TranslationUtils.PICTURE_NAME);

    public static final Color DEF_BG_COLOR = top.sob.core.ui.Graphic.DEF_BG_COLOR;
    public static final Color DEF_FG_COLOR = top.sob.core.ui.Graphic.DEF_FG_COLOR;

    public static final String SHOWING_WAY_PROPERTY = "ShowWay";
    public static final String PLAIN_TEXT = "TEXT/PLAIN";
    public static final String WRAPPED_TEXT = "TEXT/WRAP";
    public static final String URL_IMG = "IMG/URL";

    public static final SwingPrintWriter out = new SwingPrintWriter(INFO_TEXT);

    static {
        INFO_TEXT.setBackground(DEF_BG_COLOR);
        INFO_TEXT.setForeground(DEF_FG_COLOR);
        top.sob.core.ui.Graphic.INFO.getContentPanel().setLayout(new BorderLayout());
        top.sob.core.ui.Graphic.INFO.getContentPanel().add(INFO_TEXT, BorderLayout.CENTER);

        IMG_FRAME.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
