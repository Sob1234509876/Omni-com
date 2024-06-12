package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.io.*;

public class MachineTemplate extends ItemTemplate {

    public Recipe[] BindedRecipes;

    @Override
    public MachineTemplate clone() {
        MachineTemplate NEW = null;
        try {
            NEW = (MachineTemplate) (super.clone());
        } catch (Exception e) {
            output.log(e);
        }
        return NEW;
    }

    public MachineTemplate setName(String Name) {
        MachineTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public MachineTemplate setDescription(String Description) {
        MachineTemplate NEW = this.clone();
        NEW.Description = Description;
        return NEW;
    }

    public MachineTemplate setFlags(String[] Flags) {
        MachineTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return NEW;
    }

    public MachineTemplate setFlagSettings(Map<String, String> FlagSettings) {
        MachineTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return NEW;
    }

    public MachineTemplate setBindedRecipes(Recipe[] BindedRecipes) {
        MachineTemplate NEW = this.clone();
        NEW.BindedRecipes = BindedRecipes;
        return NEW;
    }

}