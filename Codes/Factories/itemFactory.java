package Codes.Factories;

import java.util.HashMap;
import java.util.Map;

import Codes.GameTypes.item;
import Codes.Main.mainScript;

/**
 * This factory is used for creating items, items are stored in
 * {@code Codes.Main.mainScript.Items}
 * <p>
 * Current properties:
 * <p>
 * <blockquote>
 * 
 * <pre>
 * String name
 * String description
 * String [] flags
 * Map<String, String> flagSettings
 * </pre>
 * 
 * </blockquote>
 * <p>
 */

public class itemFactory implements factory {

    public String name = "defaultItem";
    public String description;

    public String[] flags;
    public Map<String, String> flagSettings = new HashMap<String, String>();

    public itemFactory setName(String name) {
        this.name = name;
        return this;
    }

    public itemFactory setDescription(String description) {
        this.description = description;
        return this;
    }

    public itemFactory setFlags(String[] flags) {
        this.flags = flags;
        for (String flag : flags)
            this.flagSettings.put(flag, null);
        return this;
    }

    public int register() {

        int ID = mainScript.Items.size();

        mainScript.Items.put(ID, new item(
                this.name,
                this.description,

                this.flags,
                this.flagSettings));
        return ID;
    }

    public item getProduct() {
        return new item(
                this.name,
                this.description,

                this.flags,
                this.flagSettings);
    }

}
