package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.GTag;

import java.math.BigInteger;
import java.util.Objects;

public class Element extends Material {

    private static final char[] ELEMENT_AMT_NUM = "₀₁₂₃₄₅₆₇₈₉".toCharArray();

    private final String symbol;

    public Element(@NotNull GTag<?> body, String specializedName, String symbol) {
        super(body, new Material[0], specializedName);
        this.symbol = symbol;
    }

    public static String toLoweredString(BigInteger integer) {
        var tmp = integer.toString().toCharArray();
        var sb = new StringBuilder();

        for (char t : tmp) {

            if (t < '0' || t > '9')
                sb.append(t);

            sb.append(ELEMENT_AMT_NUM[t - '0']);
        }

        return sb.toString();
    }

    @Override
    public String getChemicalName() {
        return String.format("%s%s %s",
                getSymbol(),
                toLoweredString(getAmount().toBigInteger()),
                getName());
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Element element)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(getSymbol(), element.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSymbol());
    }
}
