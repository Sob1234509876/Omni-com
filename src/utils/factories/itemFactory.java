package src.utils.factories;

import java.util.Map;

import src.gts.item;
import src.utils.reg;

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

public class ItemFactory implements Factory {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public reg<item> ParentOfThis;

    public ItemFactory setName(String Name) {
        this.Name = Name;
        return this;
    }

    public ItemFactory setDescription(String Description) {
        this.Description = Description;
        return this;
    }

    public ItemFactory setFlags(String[] Flags) {
        this.Flags = Flags;
        return this;
    }

    public ItemFactory setFlagSettings(Map<String, String> FlagSettings) {
        this.FlagSettings = FlagSettings;
        return this;
    }

}
