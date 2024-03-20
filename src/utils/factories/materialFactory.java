package src.utils.factories;

import java.util.HashMap;
import java.util.Map;

import src.gts.element;
import src.gts.material;
import src.utils.reg;

/**
 * The {@code materialFactory} factory is used for generatting massive amount of
 * items.
 * <p>
 * Available flags :
 * <p>
 * {@code "NO_UNIFICATION"} ——
 */

public class materialFactory implements factory {

    private String name = "NULL";
    private String color = "White";
    private String description = "Nothing, not even true-vaccum!";
    private material[] component;
    private element[] elements = { new elementFactory()
            .setAtomSymbol("Nl")
            .setProtonAmount(0)
            .setNeutronAmount(0)
            .getProduct() };

    private String[] flags;
    private Map<String, String> flagSettings = new HashMap<String, String>();
    private reg<material> ParentOfThis;

    public materialFactory setName(String name) {
        this.name = name;
        return this;
    }

    public materialFactory setColor(String color) {
        this.color = color;
        return this;
    }

    public materialFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public materialFactory setComponents(material[] component) {
        this.component = component;
        return this;
    }

    public materialFactory setElements(element[] elements) {
        this.elements = elements;
        return this;
    }

    public materialFactory setFlags(String[] flags) {
        this.flags = flags;
        return this;
    }

    public materialFactory setFlagSettings(Map<String, String> flagSettings) {
        this.flagSettings = flagSettings;
        return this;
    }

    public materialFactory setParentOfThis(reg<material> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public material getProduct() {

        material newMaterial;

        if (elements == null) {
            newMaterial = new material(
                    this.name,
                    this.color,
                    this.component,
                    this.flags,
                    this.flagSettings,
                    this.ParentOfThis);
        } else {
            newMaterial = new material(
                    this.name,
                    this.color,
                    this.elements,
                    this.flags,
                    this.flagSettings,
                    this.ParentOfThis);
        }

        return newMaterial;
    }

}
