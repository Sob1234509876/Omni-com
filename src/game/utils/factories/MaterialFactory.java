package game.utils.factories;

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

public class MaterialFactory extends ItemFactory {

    public String Color;
    public material[] Component;
    public element[] Elements;

    public reg<material> ParentOfThis;

    public MaterialFactory setName(String Name) {
        super.Name = Name;
        return this;
    }

    public MaterialFactory setColor(String Color) {
        this.Color = Color;
        return this;
    }

    public MaterialFactory setDescription(String Description) {
        super.Description = Description;
        return this;
    }

    public MaterialFactory setFlags(String[] Flags) {
        super.Flags = Flags;
        return this;
    }

    public MaterialFactory setFlagSettings(Map<String, String> FlagSettings) {
        super.FlagSettings = FlagSettings;
        return this;
    }

    public MaterialFactory setParentOfThis(reg<material> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public MaterialFactory setComponents(material[] Component) {
        this.Component = Component;
        return this;
    }

    public MaterialFactory setElements(element[] Elements) {
        this.Elements = Elements;
        return this;
    }

}
