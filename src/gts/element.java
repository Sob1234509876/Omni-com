package src.gts;

import java.util.Map;

import src.utils.reg;

/**
 * {@code Element} class, used in type fluid and material.
 */

public class element {

    public String chemSymbol = "Nl";
    public long protonAmount = 0;
    public long neutronAmount = 0;
    public long atomicMass = 0;
    public long amount;

    public String[] flags;
    public Map<String, String> flagSettings;

    public reg<element> ParentOfThis;

    public element(
            String chemSymbol,
            long protonAmount,
            long neutronAmount,
            reg<element> ParentOfThis) {
        this.chemSymbol = chemSymbol;
        this.protonAmount = protonAmount;
        this.neutronAmount = neutronAmount;

        this.ParentOfThis = ParentOfThis;

        this.atomicMass = this.protonAmount + this.neutronAmount;
    }

}
