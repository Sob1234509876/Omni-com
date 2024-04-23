package game.gts;

import game.utils.Reg;
import game.utils.templates.ElementTemplate;

/**
 * {@code Element} class, used in type fluid and material.
 */

public class Element extends Item{

    public static char[] ChemNumbers = "₀₁₂₃₄₅₆₇₈₉".toCharArray();
    public static char[] AtomicNumbers = "⁰¹²³⁴⁵⁶⁷⁸⁹".toCharArray();

    public String ChemSymbol;
    public Long ProtonAmount;
    public Long NeutronAmount;
    public Long AtomicMass;
    public Long Amount;
    public Reg<Element> ParentOfThis;

    public Element valueOf(ElementTemplate EF) {

        Element tmp = new Element();

        tmp.Name = EF.Name;
        tmp.Description = EF.Description;
        tmp.Flags = EF.Flags;
        tmp.FlagSettings = EF.FlagSettings;
        tmp.ParentOfThis = EF.ParentOfThis;

        tmp.ChemSymbol = EF.ChemSymbol;
        tmp.ProtonAmount = EF.ProtonAmount;
        tmp.NeutronAmount = EF.NeutronAmount;
        tmp.AtomicMass = tmp.ProtonAmount + tmp.NeutronAmount;

        return tmp;

    }

}
