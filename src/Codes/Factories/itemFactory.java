package Codes.Factories;

import java.util.HashMap;
import java.util.Map;

import Codes.GameTypes.item;
import Codes.Main.mainScript;

/**
 * This factory is used for creating items, items are stored in "public volatile
 * static Map<Integer, Codes.GameTypes.item> Codes.mainScript.Items".
 * Current properties:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * String name
 * String description
 * String type
 * String getType
 * String recipeType
 * Codes.GameTypes.item [] recipe
 * long stacksize
 * double damage
 * long temperature
 * long poison
 * long radioactivity
 * Runnable useFun
 * Runnable passiveFun
 * String [] flags
 * java.util.Map<String, String> flagSettings
 * </pre>
 * 
 * </blockquote>
 * <p>
 * After using this factory, use register() to register into
 * Codes.mainScript.Items.
 */

public class itemFactory implements factory {

    String name = "defaultItem";
    String description;
    String type;
    String getType;

    String[] flags;
    Map<String, String> flagSettings = new HashMap<String, String>();

    public itemFactory setName(String name) {
        this.name = name;
        return this;
    }

    public itemFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public itemFactory setType(String type) {
        this.type = type;
        return this;
    }

    public itemFactory setGetType(String getType) {
        this.getType = getType;
        return this;
    }

    public itemFactory setFlags(String[] flags) {
        this.flags = flags;
        for (String flag : flags)
            this.flagSettings.put(flag, null);
        return this;
    }

    public item register() {

        int ID = mainScript.Items.size();

        mainScript.Items.put(ID, new item(
                this.name,
                this.description,
                this.type,
                this.getType,

                this.flags,
                this.flagSettings));
        return mainScript.Items.get(ID);
    }

    public item getProduct() {
        return new item(
                this.name,
                this.description,
                this.type,
                this.getType,

                this.flags,
                this.flagSettings);
    }

}
