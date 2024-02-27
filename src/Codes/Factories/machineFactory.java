package Codes.Factories;

import java.util.Map;

import Codes.GameTypes.machine;
import Codes.GameTypes.recipe;

public class machineFactory implements factory {

    String name;
    String description;

    Map<String, recipe> bindedRecipe;

    String[] flags;
    Map<String, String> flagSettings;

    public machineFactory setName(String name) {
        this.name = name;
        return this;
    }

    public machineFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public machineFactory setBindedRecipe(Map<String, recipe> bindedRecipe) {
        this.bindedRecipe = bindedRecipe;
        return this;
    }

    public machineFactory setFlags(String[] flags) {
        this.flags = flags;
        return this;
    }

    public machineFactory setFlagSettings(Map<String, String> flagSettings) {
        this.flagSettings = flagSettings;
        return this;
    }

    public int register() {
        int ID = Codes.Main.mainScript.Machine.size();

        Codes.Main.mainScript.Machine.put(ID, new machine(
                name,
                description,
                bindedRecipe,
                flags,
                flagSettings));

        return ID;
    }

    public machine getProduct() {
        return new machine(
                name,
                description,
                bindedRecipe,
                flags,
                flagSettings);
    }

}