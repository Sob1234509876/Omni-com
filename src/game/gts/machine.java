package game.gts;

import game.utils.Reg;
import game.utils.templates.*;

public class Machine extends Item {

    public Recipe[] BindedRecipes;

    public Reg<Machine> ParentOfThis;

    public static Machine valueOf(MachineTemplate MF) {
        Machine tmp = new Machine();

        tmp.Name = MF.Name;
        tmp.Description = MF.Description;
        tmp.Flags = MF.Flags;
        tmp.FlagSettings = MF.FlagSettings;
        tmp.ParentOfThis = MF.ParentOfThis;

        tmp.BindedRecipes = MF.BindedRecipes;

        return tmp;

    }

    @Override
    public String toString() {
        try {
            return String.format("<%s:%s>", ParentOfThis.toString(), super.Name);
        } catch (NullPointerException e) {
            return String.format("<%s>", super.Name);
        }
    }
}
