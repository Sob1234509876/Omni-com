package Codes.Factories;

import Codes.Main.mainScript;

import java.util.HashMap;
import java.util.Map;

import Codes.GameTypes.element;
import Codes.GameTypes.fluid;
import Codes.GameTypes.material;

public class fluidFactory implements factory {

    String name = "NULL";
    String color = "NULL";
    String description = "Nothing, not even true vaccum!";
    material[] component = {};
    element[] elements = { new elementFactory()
            .setAtomSymbol("Nl")
            .setProtonAmount(0)
            .setNeutronAmount(0)
            .getProduct() };

    long temperature = 0; // Zero kelvin!

    String[] flags = {};
    Map<String, String> flagSettings = new HashMap<String, String>();

    public fluidFactory setName(String name) {
        this.name = name;
        return this;
    }

    public fluidFactory setColor(String color) {
        this.color = color;
        return this;
    }

    public fluidFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public fluidFactory setComponent(material[] component) {
        this.component = component;
        return this;
    }

    public fluidFactory setTemperature(long temperature) {
        this.temperature = temperature;
        return this;
    }

    public int register() {

        int ID = mainScript.Fluids.size();

        if (component == null) {
            mainScript.Fluids.put(ID, new fluid(this.name, this.color, this.description, this.component,
                    this.temperature, this.flags, this.flagSettings));
        } else {
            mainScript.Fluids.put(ID, new fluid(this.name, this.color, this.description, this.elements,
                    this.temperature, this.flags, this.flagSettings));
        }
        return ID;

    }

    public fluid getProduct() {
        if (component == null) {
            return new fluid(this.name, this.color, this.description, this.component, this.temperature, this.flags,
                    this.flagSettings);
        } else {
            return new fluid(this.name, this.color, this.description, this.elements, this.temperature, this.flags,
                    this.flagSettings);
        }
    }

}
