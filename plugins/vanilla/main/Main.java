package vanilla.main;

import game.io.*;
import game.gts.*;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * 
 * @version 2.0.2a
 */

public class Main {

    public static final String __VERSION__ = "2.1.1a";
    public static final game.utils.Reg<Item> VanillaItemReg = new game.utils.Reg<>("vanilla");
    // METAish

    static {

        VanillaItemReg.add(Item.valueOf(new game.utils.templates.ItemTemplate()
                .setName("ALPHA")));

        try {

            Class.forName("vanilla.init.CreateNewSave");
            Class.forName("vanilla.init.Play");
            Class.forName("vanilla.init.Play$1");
            Class.forName("vanilla.init.Play$2");
            Class.forName("vanilla.init.InitGameResource");

            Class.forName("vanilla.net.LServer");
            Class.forName("vanilla.net.LClient");
            Class.forName("vanilla.net.LCMDTimer");
            Class.forName("vanilla.net.LServerCMDSolver");

            Class.forName("vanilla.utils.socket");

            Class.forName("math.lib.binary");

        } catch (Exception e) {
            output.log(e);
        }

    }
    // Adds the item ALPHA to the register and also init. URLClassLoader`s damn URL
    // set.

    /**
     * The entry of this plugin.
     */
    public static void main(String[] args) throws Exception {

        output.log(VanillaItemReg.get(0).Name);
        output.log("2024.03.18 : Alpha success (1.1.0)");
        output.log("2024.04.08 : Epic Rebirth  (1.2.3)");
        output.log("Omni co., Ltd.");

        output.log("______________________________________");
        output.log(" _");
        output.log("/ \\ |/\\/\\ |/\\ .   _  _     |  _|_  _|");
        output.log("\\_/ | | | | | |  |_ |_| ., |_  |  |_|.");
        output.log("______________________________________");

        // Happy coding and loading.

        new VanillaCmdSolver().start();
    }

}
