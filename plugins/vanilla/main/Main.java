package vanilla.main;

import java.net.*;

import game.io.*;
import game.gts.*;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * @version 2.0.2a
 */


public class Main {

    private static URL[] T_URLS = new URL[1];
    //TMP
    public static final String               __VERSION__ = "21a";
    public static final game.utils.Reg<Item> VanillaItemReg  = new game.utils.Reg<>("vanilla");
    // METAish

    static {

        VanillaItemReg.add(Item.valueOf(new game.utils.templates.ItemTemplate()
                .setName("ALPHA"))
                );
            try {
                T_URLS[0] = new URL(String.format("file:%s/vanilla.jar", game.main.Main.PLUGINS_PATH));
            } catch (Exception e) {
                output.log(e);
            }
    }
    // Adds the item ALPHA to the register and also init. URLClassLoader`s damn URL set.

    public static final URL[]          THIS_URLS         = T_URLS;
    public static final URLClassLoader THIS_CLASS_LOADER = new URLClassLoader(THIS_URLS.clone());
    // Loaders

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

        CoreCmdSolver();
    }


    /**
     * The part where the cmd line of the src works.
     * 
     * @throws Exception
     */
    private static void CoreCmdSolver() throws Exception {

        Thread VanillaCmdSolver = new Thread(new VanillaCmdSolver(), "VCL");

        VanillaCmdSolver.start();

    }

}
