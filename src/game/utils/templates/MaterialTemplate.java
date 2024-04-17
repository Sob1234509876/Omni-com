package game.utils.templates;

import java.util.Map;

import game.gts.*;
import game.utils.reg;

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
    public material[] Component;
    public element[] Elements;

    public reg<material> ParentOfThis;

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

    public MaterialTemplate setParentOfThis(reg<material> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public MaterialTemplate setComponents(material[] Component) {
        this.Component = Component;
        return this;
    }

    public MaterialTemplate setElements(element[] Elements) {
        this.Elements = Elements;
        return this;
    }

}
