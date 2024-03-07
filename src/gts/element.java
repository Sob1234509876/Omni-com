package src.gts;

/*
 * Element class, used in type fluid and material.
 */

public class element {

    public String chemSymbol = "Nl";
    public long protonAmount = 0;
    public long neutronAmount = 0;
    public long atomicMass = 0;
    public long amount;

    public element(
            String chemSymbol,
            long protonAmount,
            long neutronAmount) {
        this.chemSymbol = chemSymbol;
        this.protonAmount = protonAmount;
        this.neutronAmount = neutronAmount;

        this.atomicMass = this.protonAmount + this.neutronAmount;
    }

}
