package top.sob.vanilla.game.gt.abs;

import java.math.BigDecimal;

public interface Element extends Material {

    char[] ELEMENT_AMT_NUM = "₀₁₂₃₄₅₆₇₈₉".toCharArray();

    static String toLoweredString(BigDecimal decimal) {
        var tmp = decimal.toBigInteger().toString().toCharArray();
        var sb = new StringBuilder();

        for (char t : tmp) {

            if (t < '0' || t > '9')
                sb.append(t);

            sb.append(ELEMENT_AMT_NUM[t - '0']);
        }

        return sb.toString();
    }

    @Override
    default String getChemicalName() {
        return String.format("%s%s",
                getSymbol(),
                toLoweredString(getAmount().getDecimalAmount()));
    }

    String getSymbol();

}
