package top.sob.vanilla.game.gt.abs;

import top.sob.core.api.devTools.Amount;

import java.math.BigDecimal;

public interface Isotope extends Element {

    char[] ISOTOPE_WEIGHT_NUM = "⁰¹²³⁴⁵⁶⁷⁸⁹".toCharArray();

    Amount getWeight();

    Element getElementOf();

    Amount getRad();

    static String toUpperString(BigDecimal decimal) {
        var tmp = decimal.toBigInteger().toString().toCharArray();
        var sb = new StringBuilder();

        for (char t : tmp) {

            if (t < '0' || t > '9')
                sb.append(t);

            sb.append(ISOTOPE_WEIGHT_NUM[t - '0']);
        }

        return sb.toString();
    }

    @Override
    default String getChemicalName() {
        return String.format("%s%s",
                toUpperString(getWeight().getDecimalAmount()),
                Element.super.getChemicalName());
    }
}
