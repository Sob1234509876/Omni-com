package Codes.Factories;

import Codes.GameTypes.element;

/**
 * The {@code elementFactory} class is used for creating elements, elements are
 * stored in {@code Codes.Main.mainScript.Elements}
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

public class elementFactory implements factory {

    String atomSymbol = "Nl";
    long protonAmount = 0;
    long neutronAmount = 0;

    public elementFactory setAtomSymbol(String atomSymbol) {
        this.atomSymbol = atomSymbol;
        return this;
    }

    public elementFactory setProtonAmount(long protonAmount) {
        this.protonAmount = protonAmount;
        return this;
    }

    public elementFactory setNeutronAmount(long neutronAmount) {
        this.neutronAmount = neutronAmount;
        return this;
    }

    public int register() {

        int ID = Codes.Main.mainScript.Elements.size();

        Codes.Main.mainScript.Elements.put(ID, new element(
                atomSymbol,
                protonAmount,
                neutronAmount));

        return ID;
    }

    public element getProduct() {
        return new element(
                atomSymbol,
                protonAmount,
                neutronAmount);
    }

}
