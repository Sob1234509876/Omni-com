package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.utils.Reg;

public class FluidTemplate extends ItemTemplate {

    public String Color;
    public Material[] Component;
    public Element[] Elements;
    public long Temperature;
    public Reg<Fluid> ParentOfThis;

    
    public FluidTemplate setName(String name) {
        super.Name = name;
        return this;
    }

    public FluidTemplate setDescription(String description) {
        super.Description = description;
        return this;
    }

    public FluidTemplate setFlags(String[] flags) {
        super.Flags = flags;
        return this;
    }

    public FluidTemplate setFlagSettings(Map<String, String> flagSettings) {
        super.FlagSettings = flagSettings;
        return this;
    }

    public FluidTemplate setColor(String color) {
        this.Color = color;
        return this;
    }

    public FluidTemplate setComponent(Material[] component) {
        this.Component = component;
        return this;
    }

    public FluidTemplate setTemperature(long temperature) {
        this.Temperature = temperature;
        return this;
    }


}
