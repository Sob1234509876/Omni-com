package game.gts;

import java.util.Map;

import game.utils.templates.*;

//TODO : LoadChemFormula() & LoadItems()

/**
 * {@code material} class, use for making formatted items
 * <p>
 * example : Cyberium plate & Cyberium screw; Sodium ingot & Sodium dust
 */

public class Material extends Item {

    public String Color;
    public String ChemFormula;
    public Material[] Component;
    public Element[] Elements;

    public Map<String, Integer> CreatedItemsID;

    public Long Amount;

    public static Material valueOf(MaterialTemplate MF) {
        Material tmp = new Material();

        tmp.Name = MF.Name;
        tmp.Description = MF.Description;
        tmp.Flags = MF.Flags;
        tmp.FlagSettings = MF.FlagSettings;

        tmp.Color = MF.Color;
        tmp.Component = MF.Component;
        tmp.Elements = MF.Elements;

        return tmp;
    }

}
