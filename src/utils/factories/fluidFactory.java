package src.utils.factories;

import java.util.HashMap;
import java.util.Map;

import src.gts.element;
import src.gts.fluid;
import src.gts.material;
import src.main.Main;

public class fluidFactory implements factory {

    private String name = "NULL";
    private String color = "NULL";
    private String description = "Nothing, not even true vaccum!";
    private material[] component = {};
    private element[] elements = { new elementFactory()
            .setAtomSymbol("Nl")
            .setProtonAmount(0)
            .setNeutronAmount(0)
            .getProduct() };

    private long temperature = 0; // Zero kelvin!

    private String[] flags = {};
    private Map<String, String> flagSettings = new HashMap<String, String>();

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

        int ID = Main.Fluids.size();

        if (component == null) {
            Main.Fluids.add(new fluid(this.name, this.color, this.description, this.component,
                    this.temperature, this.flags, this.flagSettings));
        } else {
            Main.Fluids.add(new fluid(this.name, this.color, this.description, this.elements,
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
