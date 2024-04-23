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

    @Override
    public ElementTemplate clone() {
        ElementTemplate NEW = null;
        try {
            NEW = (ElementTemplate)(super.clone());
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
        return NEW;
    }

    public ElementTemplate setName(String Name) {
        ElementTemplate NEW = this.clone();
        NEW.Name = Name;
        return NEW;
    }

    public ElementTemplate setDescription(String Description) {
        ElementTemplate NEW = this.clone();
        NEW.Description = Description;
        return this;
    }

    public ElementTemplate setFlags(String[] Flags) {
        ElementTemplate NEW = this.clone();
        NEW.Flags = Flags;
        return this;
    }

    public ElementTemplate setFlagSettings(Map<String, String> FlagSettings) {
        
        ElementTemplate NEW = this.clone();
        NEW.FlagSettings = FlagSettings;
        return this;
    }
    public ElementTemplate setAtomSymbol(String ChemSymbol) {
        
        ElementTemplate NEW = this.clone();
        NEW.ChemSymbol = ChemSymbol;
        return this;
    }

    public ElementTemplate setProtonAmount(long ProtonAmount) {
        
        ElementTemplate NEW = this.clone();
        NEW.ProtonAmount = ProtonAmount;
        return this;
    }

    public ElementTemplate setNeutronAmount(long NeutronAmount) {
        
        ElementTemplate NEW = this.clone();
        NEW.NeutronAmount = NeutronAmount;
        return this;
    }


}
