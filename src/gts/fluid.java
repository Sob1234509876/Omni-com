package src.gts;

import java.util.Map;

/**
 * 
 */

public class fluid {

    public String name;
    public String color;
    public String description;
    public material[] component;
    public element[] elements;

    public long temperature;

    public String[] flags;
    public Map<String, String> flagSettings;

    public String chemFormula;

    public fluid(
            String name,
            String color,
            String description,
            material[] component,

            long temperature,

            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.component = component;

        this.temperature = temperature;

        this.flags = flags;
        this.flagSettings = flagSettings;

        for (material matter : component) {
            chemFormula += "(" + matter.chemFormula + ")" + matter.amount;
        }
    }

    public fluid(
            String name,
            String color,
            String description,
            element[] elements,

            long temperature,

            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.elements = elements;

        this.temperature = temperature;

        this.flags = flags;
        this.flagSettings = flagSettings;

        for (element element : elements) {
            chemFormula += element.chemSymbol + element.amount;
        }

    }

}
