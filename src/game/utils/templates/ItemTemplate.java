package game.utils.templates;

import java.util.Map;

import game.gts.item;
import game.utils.reg;

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

public class ItemTemplate implements Template {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public reg<item> ParentOfThis;

    public ItemTemplate setName(String Name) {
        this.Name = Name;
        return this;
    }

    public ItemTemplate setDescription(String Description) {
        this.Description = Description;
        return this;
    }

    public ItemTemplate setFlags(String[] Flags) {
        this.Flags = Flags;
        return this;
    }

    public ItemTemplate setFlagSettings(Map<String, String> FlagSettings) {
        this.FlagSettings = FlagSettings;
        return this;
    }

}
