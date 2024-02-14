package Codes.Factories;

import Codes.GameTypes.element;
import Codes.GameTypes.material;

import java.util.HashMap;
import java.util.Map;

public class materialFactory implements factory {

    String name = "NULL";
    String color = "White";
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

    public material register() {

        int ID = Codes.Main.mainScript.Materials.size();

        Codes.Main.mainScript.Materials.put(ID, new material());
    }

    public material getProduct() {
    }

}
