package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.io.output;
import game.utils.Reg;

/**
 * The {@code materialFactory} factory is used for generatting massive amount of
 * items.
 * <p>
 * Available flags :
 * <p>
 * WIP
 */

public class MaterialTemplate extends ItemTemplate {

    public String Color;
    public Material[] Component;
    public Element[] Elements;

    public Reg<Material> ParentOfThis;

    @Override
    public MaterialTemplate clone() {
        MaterialTemplate NEW = null;
        try {
            NEW = (MaterialTemplate) (super.clone());
        } catch (Exception e) {
            output.log(e);
        }
        return NEW;
    }

    public MaterialTemplate setName(String Name) {
        MaterialTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public MaterialTemplate setColor(String Color) {
        MaterialTemplate NEW = this.clone();
        NEW.Color = Color;
        return NEW;
    }

    public MaterialTemplate setDescription(String Description) {
        MaterialTemplate NEW = this.clone();
        NEW.Description = Description;
        return NEW;
    }

    public MaterialTemplate setFlags(String[] Flags) {
        MaterialTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return NEW;
    }

    public MaterialTemplate setFlagSettings(Map<String, String> FlagSettings) {
        MaterialTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return NEW;
    }

    public MaterialTemplate setParentOfThis(Reg<Material> ParentOfThis) {
        MaterialTemplate NEW = this.clone();
        NEW.ParentOfThis = ParentOfThis;
        return NEW;
    }

    public MaterialTemplate setComponents(Material[] Component) {
        MaterialTemplate NEW = this.clone();
        NEW.Component = Component;
        return NEW;
    }

    public MaterialTemplate setElements(Element[] Elements) {
        MaterialTemplate NEW = this.clone();
        NEW.Elements = Elements;
        return NEW;
    }

}
