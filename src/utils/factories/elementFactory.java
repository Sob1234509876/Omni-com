package src.utils.factories;

import java.util.Map;

import src.gts.element;
import src.utils.reg;

/**
 * The {@code elementFactory} class is used for creating elements, elements are
 * stored in {@code Codes.main.Main.Elements}
 * <p>
 * Current properties :
 * <blockquote>
 * 
 * <pre>
 * String atomSymbol
 * long protonAmount
 * long neutronAmount
 * </pre>
 * 
 * </blockquote>
 */

public class ElementFactory extends ItemFactory {

    public String ChemSymbol = "Nl";
    public long ProtonAmount = 0;
    public long NeutronAmount = 0;
    public reg<element> ParentOfThis;

    public ElementFactory setName(String name) {
        super.Name = name;
        return this;
    }

    public ElementFactory setDescription(String description) {
        super.Description = description;
        return this;
    }

    public ElementFactory setFlags(String[] flags) {
        super.Flags = flags;
        return this;
    }

    public ElementFactory setFlagSettings(Map<String, String> flagSettings) {
        super.FlagSettings = flagSettings;
        return this;
    }
    public ElementFactory setAtomSymbol(String AtomSymbol) {
        this.ChemSymbol = AtomSymbol;
        return this;
    }

    public ElementFactory setProtonAmount(long ProtonAmount) {
        this.ProtonAmount = ProtonAmount;
        return this;
    }

    public ElementFactory setNeutronAmount(long NeutronAmount) {
        this.NeutronAmount = NeutronAmount;
        return this;
    }


}
