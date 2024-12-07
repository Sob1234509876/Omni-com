package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.GTag;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Isotope extends Element {

    private static final char[] ISOTOPE_WEIGHT_NUM = "⁰¹²³⁴⁵⁶⁷⁸⁹".toCharArray();

    private final Element elementOf;
    private final BigDecimal rad;
    private final BigDecimal weight;

    public Isotope(@NotNull GTag<?> body, String specializedName, Element of, BigDecimal rad, BigDecimal weight) {
        super(body, specializedName, of.getSymbol());
        this.elementOf = of;
        this.rad = rad;
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Element getElementOf() {
        return elementOf;
    }

    public BigDecimal getRad() {
        return rad;
    }

    public static String toUpperString(BigInteger integer) {
        var tmp = integer.toString().toCharArray();
        var sb = new StringBuilder();

        for (char t : tmp) {

            if (t < '0' || t > '9')
                sb.append(t);

            sb.append(ISOTOPE_WEIGHT_NUM[t - '0']);
        }

        return sb.toString();
    }

    @Override
    public String getChemicalName() {
        return String.format("%s%s%s %s",
                toUpperString(getWeight().toBigInteger()),
                getSymbol(),
                toLoweredString(getAmount().toBigInteger()),
                getName());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Isotope isotope)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(getElementOf(), isotope.getElementOf()) && Objects.equals(getRad(), isotope.getRad()) && Objects.equals(getWeight(), isotope.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getElementOf(), getRad(), getWeight());
    }
}
