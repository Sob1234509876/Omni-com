package src.utils.factories;

import src.gts.element;

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

        int ID = src.main.Main.Elements.size();

        src.main.Main.Elements.add(new element(
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
