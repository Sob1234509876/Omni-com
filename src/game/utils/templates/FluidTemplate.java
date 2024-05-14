package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.io.*;
import game.utils.*;

public class FluidTemplate extends ItemTemplate {

    public String Color;
    public Material[] Component;
    public Element[] Elements;
    public long Temperature;
    public Reg<Fluid> ParentOfThis;

    @Override
    public FluidTemplate clone() {
        FluidTemplate NEW = null;
        try {
            NEW = (FluidTemplate) (super.clone());
        } catch (Exception e) {
            output.log(e);
        }
        return NEW;
    }

    public FluidTemplate setName(String Name) {
        FluidTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public FluidTemplate setDescription(String Description) {
        FluidTemplate NEW = this.clone();
        NEW.Description = Description;
        return NEW;
    }

    public FluidTemplate setFlags(String[] Flags) {
        FluidTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return NEW;
    }

    public FluidTemplate setFlagSettings(Map<String, String> FlagSettings) {
        FluidTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return NEW;
    }

    public FluidTemplate setColor(String Color) {
        FluidTemplate NEW = this.clone();
        NEW.Color = Color;
        return NEW;
    }

    public FluidTemplate setComponent(Material[] Component) {
        FluidTemplate NEW = this.clone();
        NEW.Component = Component;
        return NEW;
    }

    public FluidTemplate setTemperature(long Temperature) {
        FluidTemplate NEW = this.clone();
        NEW.Temperature = Temperature;
        return NEW;
    }

}
