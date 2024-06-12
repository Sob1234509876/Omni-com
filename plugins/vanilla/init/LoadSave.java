package vanilla.init;

import java.io.*;
import java.util.*;

import game.main.*;

// TODO: Load in GTs even when they are not called in the save.

/** Use for loading data from save. */
public class LoadSave {

    /**
     * Loads the save file from {@link Play#GameFile}.
     * <h1>Format
     * </h1>
     * t/data
     * <p>
     * 
     * <pre>{@code
     * ItemA:ITEM|1
     * MachineB:MACHINE|2
     * }
     * </pre>
     * <p>
     * What this should be loaded into is this :
     * <p>
     * 
     * <pre>
     * data.Items = {(Item)(ItemA):1};
     * data.Machines = {(Machine)(MachineB):2};
     * ...;
     * </pre>
     * 
     * Note that the gts <b>MUST</b> be loaded in {@link game.api.data} or else it will
     * throw a {@link NullPointerException}.
     * 
     * @throws IOException          throws when the save file is inaccesible or
     *                              other stuffs happen when loading the save file.
     * @throws NullPointerException throws when the type of item could not be found.
     */
    public static void Load() throws IOException, NullPointerException {
        Properties t = new Properties();
        t.load(new FileReader(Play.GameFile, Main.DEF_CHARSET));
        //Init

    }

}
