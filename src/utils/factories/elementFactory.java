package src.utils.factories;

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

public class elementFactory implements factory {

    private String atomSymbol = "Nl";
    private long protonAmount = 0;
    private long neutronAmount = 0;
    private reg<element> ParentOfThis;

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

    public elementFactory setParentOfThis(reg<element> ParentOfThis) {
        this.ParentOfThis = ParentOfThis;
        return this;
    }

    public element getProduct() {
        return new element(
                this.atomSymbol,
                this.protonAmount,
                this.neutronAmount,
                this.ParentOfThis);
    }

}
