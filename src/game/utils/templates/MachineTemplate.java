package game.utils.templates;

import java.util.Map;

import game.gts.Machine;
import game.gts.Recipe;
import game.utils.Reg;

public class MachineTemplate extends ItemTemplate {

    public Recipe[] BindedRecipes;

    public Reg<Machine> ParentOfThis;

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

    public MachineTemplate setBindedRecipes(Recipe[] BindedRecipes) {
        this.BindedRecipes = BindedRecipes;
        return this;
    }


}