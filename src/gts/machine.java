package src.gts;

import java.util.Map;

public class machine {

    String name;
    String description;

    Map<String, recipe> bindedRecipe;

    String[] flags;
    Map<String, String> flagSettings;

    public machine(

            String name,
            String description,

            Map<String, recipe> bindedRecipe,

            String[] flags,
            Map<String, String> flagSettings) {
        this.name = name;
        this.description = description;
        this.bindedRecipe = bindedRecipe;
        this.flags = flags;
        this.flagSettings = flagSettings;
    }
}
