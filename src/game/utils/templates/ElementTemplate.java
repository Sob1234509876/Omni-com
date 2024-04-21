package game.utils.templates;

import java.util.Map;

import game.gts.Element;
import game.utils.Reg;

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

public class ElementTemplate extends ItemTemplate {

    public String ChemSymbol = "Nl";
    public long ProtonAmount = 0;
    public long NeutronAmount = 0;
    public Reg<Element> ParentOfThis;

    public ElementTemplate setName(String name) {
        super.Name = name;
        return this;
    }

    public ElementTemplate setDescription(String description) {
        super.Description = description;
        return this;
    }

    public ElementTemplate setFlags(String[] flags) {
        super.Flags = flags;
        return this;
    }

    public ElementTemplate setFlagSettings(Map<String, String> flagSettings) {
        super.FlagSettings = flagSettings;
        return this;
    }
    public ElementTemplate setAtomSymbol(String AtomSymbol) {
        this.ChemSymbol = AtomSymbol;
        return this;
    }

    public ElementTemplate setProtonAmount(long ProtonAmount) {
        this.ProtonAmount = ProtonAmount;
        return this;
    }

    public ElementTemplate setNeutronAmount(long NeutronAmount) {
        this.NeutronAmount = NeutronAmount;
        return this;
    }


}
