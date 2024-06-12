package vanilla.main;

import game.io.*;
import game.utils.templates.*;

import java.io.IOException;

import game.api.Register;
import game.gts.*;

import vanilla.init.*;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * 
 * @version 2.0.2a
 */
public class Main {

    public static final String __VERSION__ = "2.1.1a";
    // METAish

    static {

        game.api.data.Items.add(Item.valueOf(new ItemTemplate()
                .setName("ALPHA")));

        try {

            Class.forName("vanilla.data");

            Class.forName("vanilla.init.CreateNewSave");
            Class.forName("vanilla.init.Play");
            Class.forName("vanilla.init.InitGameResource");
            Class.forName("vanilla.init.Load");

            Class.forName("vanilla.net.LServer");
            Class.forName("vanilla.net.LClient");
            Class.forName("vanilla.net.LCMDTimer");
            Class.forName("vanilla.net.LServerCMDSolver");

            Class.forName("vanilla.utils.socket");
            Class.forName("vanilla.utils.search");

            Class.forName("vanilla.impl.StdEntry");
            // Class.forName("math.lib.binary");

        } catch (Exception e) {
            output.log(e);
        }

    }
    // Adds the item ALPHA to the register and also init. URLClassLoader`s damn URL
    // set.

    /**
     * The entry of this plugin.
     */
    @Register
    public static void main(String[] args) throws Exception {

        output.log("ALPHA");
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

    public static void Load() throws IOException {
        InitGameResource.Load();
    }

}
