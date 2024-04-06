package src.utils.factories;

import java.util.Map;

import src.gts.*;
import src.utils.reg;

public class FluidFactory extends ItemFactory {

    public String Color;
    public material[] Component;
    public element[] Elements;
    public long Temperature;
    public reg<fluid> ParentOfThis;

    
    public FluidFactory setName(String name) {
        super.Name = name;
        return this;
    }

    public FluidFactory setDescription(String description) {
        super.Description = description;
        return this;
    }

    public FluidFactory setFlags(String[] flags) {
        super.Flags = flags;
        return this;
    }

    public FluidFactory setFlagSettings(Map<String, String> flagSettings) {
        super.FlagSettings = flagSettings;
        return this;
    }

    public FluidFactory setColor(String color) {
        this.Color = color;
        return this;
    }

    public FluidFactory setComponent(material[] component) {
        this.Component = component;
        return this;
    }

    public FluidFactory setTemperature(long temperature) {
        this.Temperature = temperature;
        return this;
    }


}
