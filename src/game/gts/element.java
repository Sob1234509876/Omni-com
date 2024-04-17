package game.gts;

import game.utils.reg;
import game.utils.templates.ElementTemplate;

/**
 * {@code Element} class, used in type fluid and material.
 */

public class element extends item{

    public static char[] ChemNumbers = "₀₁₂₃₄₅₆₇₈₉".toCharArray();
    public static char[] AtomicNumbers = "⁰¹²³⁴⁵⁶⁷⁸⁹".toCharArray();

    public String ChemSymbol;
    public Long ProtonAmount;
    public Long NeutronAmount;
    public Long AtomicMass;
    public Long Amount;
    public reg<element> ParentOfThis;

    public element valueOf(ElementTemplate EF) {

        element tmp = new element();

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
