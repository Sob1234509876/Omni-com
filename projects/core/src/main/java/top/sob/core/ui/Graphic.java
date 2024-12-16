package top.sob.core.ui;

import java.util.Objects;

import javax.swing.ImageIcon;

import org.apiguardian.api.API;
import top.sob.core.proof.Static;
import top.sob.core.Meta;

@Static
@API(status = API.Status.INTERNAL, since = "1.2.8a")
public final class Graphic {

    private static final ImageIcon ICON = new ImageIcon(Objects.requireNonNull(Meta.getThisClassLoader()
            .getResource("assets/texture/icon.png")));

    private static final IConsole CONSOLE = new IConsole();

    public static ImageIcon getIcon() {
        return ICON;
    }

    public static IConsole getIConsole() {
        return CONSOLE;
    }
}
