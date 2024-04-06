package src.gts;

import java.util.Map;

import src.utils.reg;
import src.utils.factories.*;

//TODO : LoadChemFormula() & LoadItems()

/**
 * {@code material} class, use for making formatted items
 * <p>
 * example : Cyberium plate & Cyberium screw; Sodium ingot & Sodium dust
 */

public class material extends item {

    public String Color;
    public String ChemFormula;
    public material[] Component;
    public element[] Elements;

    public Map<String, Integer> CreatedItemsID;

    public Long Amount;

    public reg<material> ParentOfThis;

    public static material valueOf(MaterialFactory MF) {
        material tmp = new material();

        tmp.Name = MF.Name;
        tmp.Description = MF.Description;
        tmp.Flags = MF.Flags;
        tmp.FlagSettings = MF.FlagSettings;
        tmp.ParentOfThis = MF.ParentOfThis;

        tmp.Color = MF.Color;
        tmp.Component = MF.Component;
        tmp.Elements = MF.Elements;

        return tmp;
    } 

}


