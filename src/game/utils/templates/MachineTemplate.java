package game.utils.templates;

import java.util.Map;

import game.gts.machine;
import game.gts.recipe;
import game.utils.reg;

public class MachineTemplate extends ItemTemplate {

    public recipe[] BindedRecipes;

    public reg<machine> ParentOfThis;

    public MachineTemplate setName(String Name) {
        super.Name = Name;
        return this;
    }

    public MachineTemplate setDescription(String Description) {
        super.Description = Description;
        return this;
    }


    public MachineTemplate setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public MachineTemplate setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }

    public MachineTemplate setBindedRecipes(recipe[] BindedRecipes) {
        this.BindedRecipes = BindedRecipes;
        return this;
    }


}