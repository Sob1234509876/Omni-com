package top.sob.core.ui;

import java.awt.Color;
import java.awt.Font;
import java.net.MalformedURLException;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import javax.swing.border.Border;

import org.apiguardian.api.API;
import top.sob.core.Utilities;
import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Static;
import top.sob.core.api.Meta;
import top.sob.core.exceptions.MissingResourceException;

@Immutable
@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class Graphic {

    @Immutable
    public static final ImageIcon ICON = new ImageIcon(Objects.requireNonNull(Meta.THIS_CLASS_LOADER
            .getResource("assets/icon.png")));

    @Immutable
    public static final JFrame DEF_FRAME;
    @Immutable
    public static final JFrame INFO_FRAME;
    @Immutable
    public static final GInput INPUT = new GInput();
    @Immutable
    public static final GOutput OUTPUT = new GOutput();
    @Immutable
    public static final GInfo INFO = new GInfo();

    @Immutable
    public static final int FRAME_HEIGHT = Integer.parseInt(Objects.requireNonNull(Utilities.getConfig("ui", "d", "height")));
    @Immutable
    public static final int FRAME_WIDTH = Integer.parseInt(Objects.requireNonNull(Utilities.getConfig("ui", "d", "width")));

    @Immutable
    public static final int FONT_SIZE = Integer.parseInt(Objects.requireNonNull(Utilities.getConfig("ui", "font", "size")));
    @Immutable
    public static final String FONT_NAME = Utilities.getConfig("ui", "font", "name");

    @SuppressWarnings("unused")
    @Immutable
    public static final Font PLAIN_FONT = new Font(
            FONT_NAME,
            Font.PLAIN,
            FONT_SIZE);

    @SuppressWarnings("unused")
    @Immutable
    public static final Font BOLD_FONT = new Font(
            FONT_NAME,
            Font.BOLD,
            FONT_SIZE);

    @SuppressWarnings("unused")
    @Immutable
    public static final Font ITALIC_FONT = new Font(
            FONT_NAME,
            Font.ITALIC,
            FONT_SIZE);

    @Immutable
    public static final Color DEF_BG_COLOR = new Color(Integer.parseInt(Objects.requireNonNull(Utilities.getConfig("ui", "color", "bg"))),
            false);
    @Immutable
    public static final Color DEF_FG_COLOR = new Color(Integer.parseInt(Objects.requireNonNull(Utilities.getConfig("ui", "color", "fg"))),
            false);

    @Immutable
    public static final Border DEF_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, DEF_FG_COLOR);

    static {

        try {

            var defName = Utilities.getConfig(Meta.LANG_URI.toURL(), "ui", "frames", "defaultName");
            var infoName = Utilities.getConfig(Meta.LANG_URI.toURL(), "ui", "frames", "infoName");

            Objects.requireNonNull(defName);
            Objects.requireNonNull(infoName);

            DEF_FRAME = new JFrame(defName);
            INFO_FRAME = new JFrame(infoName);

        } catch (NullPointerException npe) {
            throw new MissingResourceException(Meta.LANG_URI);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        DEF_FRAME.add(INPUT);
        DEF_FRAME.add(OUTPUT);
        INFO_FRAME.add(INFO);
    }

}
