package top.sob.vanilla.ui;

import top.sob.core.Utilities;
import top.sob.core.ui.GOutput;

import static top.sob.vanilla.Meta.LANG;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public final class Graphic {

    private Graphic() {
    }

    public static final GOutput INFO_TEXT = new GOutput();
    public static final GPic PIC_COMP = new GPic();
    @SuppressWarnings("unused")
    public static final JFrame PIC_FRAME = new JFrame(Utilities.getConfig(LANG, "vanilla", "ui", "frameName", "picFrame"));


    public static final Color DEF_BG_COLOR = top.sob.core.ui.Graphic.DEF_BG_COLOR;
    public static final Color DEF_FG_COLOR = top.sob.core.ui.Graphic.DEF_FG_COLOR;

    static {
        INFO_TEXT.setBackground(DEF_BG_COLOR);
        INFO_TEXT.setForeground(DEF_FG_COLOR);
        top.sob.core.ui.Graphic.INFO.getContentPanel().setLayout(new BorderLayout());
        top.sob.core.ui.Graphic.INFO.getContentPanel().add(INFO_TEXT, BorderLayout.CENTER);
    }
}
