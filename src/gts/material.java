package src.gts;

import java.util.HashMap;
import java.util.Map;

import src.utils.reg;

/**
 * {@code material} class, use for making formatted items
 * <p>
 * example : Cyberium plate & Cyberium screw; Sodium ingot & Sodium dust
 */

public class material {

    public String name;
    public String color;
    public String chemFormula;
    public material[] component;
    public element[] elements;

    public String[] flags;
    public Map<String, String> flagSettings = new HashMap<String, String>();
    public Map<String, Integer> createdItemsID = new HashMap<String, Integer>();
    public reg<material> ChildOfPlugin;

    public long amount = 0;

    public material(
            String name,
            String color,
            material[] component,
            String[] flags,
            Map<String, String> flagSettings,
            reg<material> ChildOfPlugin) {
        this.name = name;
        this.color = color;
        this.component = component;
        this.flags = flags;
        this.flagSettings = flagSettings;
        this.ChildOfPlugin = ChildOfPlugin;

        for (material matter : component) {
            this.chemFormula += "(" + matter.chemFormula + ")" + matter.amount;
        }
    }

    public material(
            String name,
            String color,
            element[] elements,
            String[] flags,
            Map<String, String> flagSettings,
            reg<material> ChildOfPlugin) {
        this.name = name;
        this.color = color;
        this.elements = elements;
        this.flags = flags;
        this.flagSettings = flagSettings;
        this.ChildOfPlugin = ChildOfPlugin;

        for (element element : elements) {
            this.chemFormula += element.chemSymbol + element.amount;
        }

    }

}
