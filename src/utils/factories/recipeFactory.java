package src.utils.factories;

import java.util.Map;

import src.gts.item;
import src.gts.recipe;

public class recipeFactory implements factory {

    private String name = "Create null";
    private String description = "Nothing!";
    private item[] input = {
            new itemFactory()
                    .setName("null")
                    .setDescription("Nothing, not even true vaccum.")
                    .getProduct()
    };
    private item[] output = {
            new itemFactory()
                    .setName("null")
                    .setDescription("Nothing, not even true vaccum.")
                    .getProduct()
    };
    private Runnable inputFun = new Runnable() {
        public void run() {
        }
    };
    private Runnable outputFun = new Runnable() {
        public void run() {
        }
    };

    private String[] flags;
    private Map<String, String> flagSettings;

    public recipeFactory setName(String name) {
        this.name = name;
        return this;
    }

    public recipeFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public recipeFactory setInput(item[] input) {
        this.input = input;
        return this;
    }

    public recipeFactory setOutput(item[] output) {
        this.output = output;
        return this;
    }

    public recipeFactory setInputFun(Runnable inputFun) {
        this.inputFun = inputFun;
        return this;
    }

    public recipeFactory setOutputFun(Runnable outputFun) {
        this.outputFun = outputFun;
        return this;
    }

    public recipeFactory setFlags(String[] flags) {
        this.flags = flags;
        return this;
    }

    public recipeFactory setFlagSettings(Map<String, String> flagSettings) {
        this.flagSettings = flagSettings;
        return this;
    }

    public int register() {
        int ID = src.main.Main.Recipe.size();

        src.main.Main.Recipe.add(new recipe(
                this.name,
                this.description,
                this.input,
                this.output,
                this.inputFun,
                this.outputFun,
                this.flags,
                this.flagSettings));

        return ID;

    }

    public recipe getProduct() {
        return new recipe(
                this.name,
                this.description,
                this.input,
                this.output,
                this.inputFun,
                this.outputFun,
                this.flags,
                this.flagSettings);
    }
}