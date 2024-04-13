package game.utils.factories;

import java.util.Map;

import game.gts.machine;
import game.gts.recipe;
import game.utils.reg;

public class MachineFactory extends ItemFactory {

    public recipe[] BindedRecipes;

    public reg<machine> ParentOfThis;

    public MachineFactory setName(String Name) {
        super.Name = Name;
        return this;
    }

    public MachineFactory setDescription(String Description) {
        super.Description = Description;
        return this;
    }


    public MachineFactory setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public MachineFactory setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }

    public MachineFactory setBindedRecipes(recipe[] BindedRecipes) {
        this.BindedRecipes = BindedRecipes;
        return this;
    }


}