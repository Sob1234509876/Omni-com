package game.gts;

import game.utils.reg;
import game.utils.templates.*;

public class machine extends item {

    public recipe[] BindedRecipes;

    public reg<machine> ParentOfThis;

    public static machine valueOf(MachineTemplate MF) {
        machine tmp = new machine();

        tmp.Name = MF.Name;
        tmp.Description = MF.Description;
        tmp.Flags = MF.Flags;
        tmp.FlagSettings = MF.FlagSettings;
        tmp.ParentOfThis = MF.ParentOfThis;

        tmp.BindedRecipes = MF.BindedRecipes;

        return tmp;

    }

}
