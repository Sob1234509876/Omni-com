package src.utils.factories;

import java.util.HashMap;
import java.util.Map;

import src.gts.element;
import src.gts.material;

/**
 * The {@code materialFactory} factory is used for generatting massive amount of
 * items.
 * <p>
 * Available flags :
 * <p>
 * {@code "NO_UNIFICATION"} ——
 */

public class materialFactory implements factory {

    String name = "NULL";
    String color = "White";
    String description = "Nothing, not even true-vaccum!";
    material[] component;
    element[] elements = { new elementFactory()
            .setAtomSymbol("Nl")
            .setProtonAmount(0)
            .setNeutronAmount(0)
            .getProduct() };

    String[] flags;
    Map<String, String> flagSettings = new HashMap<String, String>();

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

    public int register() {

        int ID = src.main.Main.Materials.size();

        material newMaterial;

        if (elements == null) {
            newMaterial = new material(name, color, component, flags, flagSettings);
        } else {
            newMaterial = new material(name, color, elements, flags, flagSettings);
        }

        src.main.Main.Materials.add(newMaterial);

        return ID;
    }

    public material getProduct() {

        material newMaterial;

        if (elements == null) {
            newMaterial = new material(name, color, component, flags, flagSettings);
        } else {
            newMaterial = new material(name, color, elements, flags, flagSettings);
        }

        return newMaterial;
    }

}
