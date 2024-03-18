package src.utils.factories;

import java.nio.file.Path;

import java.util.HashMap;
import java.util.Map;

import src.gts.item;
import src.main.Main;

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

    private String name = "defaultItem";
    private String description;

    private String[] flags;
    private Map<String, String> flagSettings = new HashMap<String, String>();

    private Path docPath;

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
        return this;
    }

    public itemFactory setFlagSettings(Map<String, String> flagSettings) {
        this.flagSettings = flagSettings;
        return this;
    }

    public itemFactory setDocPath(Path docPath) {
        this.docPath = docPath;
        return this;
    }

    public int register() {

        int ID = Main.Items.size();

        Main.Items.add(new item(
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
