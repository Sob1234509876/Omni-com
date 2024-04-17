package vanilla.init;

import game.gts.*;
import game.utils.templates.*;

import vanilla.main.*;

/**
 * Inits the resource of plugin {@code vanilla}.
 * @since game:1.2.5a vanilla:2.0.2a
 */
public class InitGameResource {
    
    public static void Init() {
        ItemTemplate TEST = new ItemTemplate()
        .setName("TEST");

        Main.VanillaItemReg.add(item.valueOf(TEST));
        TEST.setName("TEST2");

        Main.VanillaItemReg.add(item.valueOf(TEST));
        TEST.setName("TEST3");

        Main.VanillaItemReg.add(item.valueOf(TEST));
        TEST.setName("TEST4");

        Main.VanillaItemReg.add(item.valueOf(TEST));
        TEST.setName("TEST5");
    }
}
