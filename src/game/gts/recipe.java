package game.gts;

import game.utils.reg;
import game.utils.factories.*;


public class recipe extends item {

    public item[] Input;
    public item[] Output;
    public Runnable InputFun;
    public Runnable OutputFun;
    
    public reg<recipe> ParentOfThis;

    public static recipe valueOf(RecipeFactory RF) {
        recipe tmp = new recipe();
        
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

}
