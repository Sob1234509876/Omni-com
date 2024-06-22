package top.sob.core.templates;

import top.sob.core.gt.Material;

public class elementTemplate extends template {

    /**
     * The atomic numbers, use like this :
     * 
     * <pre>
     * ²³⁵UF₆ : High concetration uranium hexaflouride.
     * ¹⁹⁸AuCl₄ : Radioactive chloroauric acid
     * ...
     * </pre>
     */
    public static final char[] ATOMIC_NUM_CHAR = "⁰¹²³⁴⁵⁶⁷⁸⁹".toCharArray();

    /**
     * The chemical amount numbers, use like this :
     * 
     * <pre>
     * H₂O : Water
     * NH₃ : Ammonia
     * ...
     * </pre>
     */
    public static final char[] CHEMICAL_NUM_CHAR = "₀₁₂₃₄₅₆₇₈₉".toCharArray();

    /** The chemical formula */
    protected String chemFormula;

    /**
     * 
     * Returns the chemical formula of this.
     * 
     * @return the chemical formula of this
     */
    public String getChemFormula() {
        return chemFormula;
    }

    /**
     * Returns the material of this.
     * 
     * @return the material of this
     */
    public Material getMaterial() {
        return null;
    }

    /**
     * 
     * Sets this chemical formula into a new one.
     * 
     * @param o the new chemical formula
     * @return returns this
     */
    public elementTemplate setChemFormula(String o) {
        chemFormula = o;
        return this;
    }

}
