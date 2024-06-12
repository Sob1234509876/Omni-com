package game.gts;

import game.utils.templates.*;

public class Machine extends Item {

    public Recipe[] BindedRecipes;

    public static Machine valueOf(MachineTemplate MF) {
        Machine tmp = new Machine();

        tmp.Name = MF.Name;
        tmp.Description = MF.Description;
        tmp.Flags = MF.Flags;
        tmp.FlagSettings = MF.FlagSettings;

        tmp.BindedRecipes = MF.BindedRecipes;

        return tmp;

    }

}
