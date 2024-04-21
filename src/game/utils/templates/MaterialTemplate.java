package game.utils.templates;

import java.util.Map;

import game.gts.*;
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

    public MaterialTemplate setName(String Name) {
        super.Name = Name;
        return this;
    }

    public MaterialTemplate setColor(String Color) {
        this.Color = Color;
        return this;
    }

    public MaterialTemplate setDescription(String Description) {
        super.Description = Description;
        return this;
    }

    public MaterialTemplate setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public MaterialTemplate setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }

    public MaterialTemplate setParentOfThis(Reg<Material> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public MaterialTemplate setComponents(Material[] Component) {
        this.Component = Component;
        return this;
    }

    public MaterialTemplate setElements(Element[] Elements) {
        this.Elements = Elements;
        return this;
    }

}
