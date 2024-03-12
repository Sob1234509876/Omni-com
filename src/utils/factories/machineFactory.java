package src.utils.factories;

import java.util.Map;

import src.gts.machine;
import src.gts.recipe;

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
        int ID = src.main.Main.Machine.size();

        src.main.Main.Machine.add(new machine(
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