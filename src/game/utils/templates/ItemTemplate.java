package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.io.*;
import game.utils.*;

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
public class ItemTemplate implements Template, Cloneable {

    public String Name;
    public String Description;
    public String[] Flags;
    public Map<String, String> FlagSettings;
    public Reg<Item> ParentOfThis;

    @Override
    public ItemTemplate clone() {
        ItemTemplate NEW = null;
        try {
            NEW = (ItemTemplate) (super.clone());
        } catch (Exception e) {
            output.log(e);
        }
        return NEW;
    }

    public ItemTemplate setName(String Name) {
        ItemTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public ItemTemplate setDescription(String Description) {
        ItemTemplate NEW = this.clone();
        NEW.Description = Description;
        return NEW;
    }

    public ItemTemplate setFlags(String[] Flags) {
        ItemTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return NEW;
    }

    public ItemTemplate setFlagSettings(Map<String, String> FlagSettings) {
        ItemTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return NEW;
    }

}
