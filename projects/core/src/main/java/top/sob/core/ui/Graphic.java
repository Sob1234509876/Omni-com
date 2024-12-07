package top.sob.core.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import javax.swing.border.Border;

import org.apiguardian.api.API;
import top.sob.core.utils.CommonUtils;
import top.sob.core.annotations.proof.Static;
import top.sob.core.Meta;
import top.sob.core.utils.TranslationUtils;

@SuppressWarnings("deprecation")
@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class Graphic {

    public static final ImageIcon ICON = new ImageIcon(Objects.requireNonNull(Meta.THIS_CLASS_LOADER
            .getResource("assets/icon.png")));

    public static final JFrame DEF_FRAME;
    public static final JFrame INFO_FRAME;
    public static final GInput INPUT = new GInput();
    public static final GOutput OUTPUT = new GOutput();
    public static final GInfo INFO = new GInfo();

    @SuppressWarnings("deprecation")
    public static final int FRAME_HEIGHT = Integer.parseInt(Objects.requireNonNull(CommonUtils.getConfig("ui", "d", "height")));
    @SuppressWarnings("deprecation")
    public static final int FRAME_WIDTH = Integer.parseInt(Objects.requireNonNull(CommonUtils.getConfig("ui", "d", "width")));

    @SuppressWarnings("deprecation")
    public static final int FONT_SIZE = Integer.parseInt(Objects.requireNonNull(CommonUtils.getConfig("ui", "font", "size")));
    @SuppressWarnings("deprecation")
    public static final String FONT_NAME = CommonUtils.getConfig("ui", "font", "name");

    @SuppressWarnings("unused")
    public static final Font PLAIN_FONT = new Font(
            FONT_NAME,
            Font.PLAIN,
            FONT_SIZE);

    @SuppressWarnings("unused")
    public static final Font BOLD_FONT = new Font(
            FONT_NAME,
            Font.BOLD,
            FONT_SIZE);

    @SuppressWarnings("unused")
    public static final Font ITALIC_FONT = new Font(
            FONT_NAME,
            Font.ITALIC,
            FONT_SIZE);

    @SuppressWarnings("deprecation")
    public static final Color DEF_BG_COLOR = new Color(Integer.parseInt(Objects.requireNonNull(CommonUtils.getConfig("ui", "color", "bg"))),
            false);
    @SuppressWarnings("deprecation")
    public static final Color DEF_FG_COLOR = new Color(Integer.parseInt(Objects.requireNonNull(CommonUtils.getConfig("ui", "color", "fg"))),
            false);

    public static final Border DEF_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, DEF_FG_COLOR);

    static {

        DEF_FRAME = new JFrame(TranslationUtils.TERMINAL_NAME);
        INFO_FRAME = new JFrame(TranslationUtils.INFO_NAME);

        DEF_FRAME.add(INPUT);
        DEF_FRAME.add(OUTPUT);
        INFO_FRAME.add(INFO);
    }

}
