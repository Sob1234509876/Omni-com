package game.gts;

import game.utils.Reg;
import game.utils.templates.*;

public class Recipe extends Item {

    public Item[] Input;
    public Item[] Output;
    public Runnable InputFun;
    public Runnable OutputFun;

    public Reg<Recipe> ParentOfThis;

    public static Recipe valueOf(RecipeTemplate RF) {
        Recipe tmp = new Recipe();

        tmp.Name = RF.Name;
        tmp.Description = RF.Description;
        tmp.Flags = RF.Flags;
        tmp.FlagSettings = RF.FlagSettings;
        tmp.ParentOfThis = RF.ParentOfThis;

        tmp.Input = RF.Input;
        tmp.Output = RF.Output;
        tmp.InputFun = RF.InputFun;
        tmp.OutputFun = RF.OutputFun;

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
