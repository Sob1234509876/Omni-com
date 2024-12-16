package top.sob.vanilla.game.gt.abs;

import top.sob.core.api.devTools.GInstance;

import java.math.BigDecimal;

public interface Material extends GInstance {

    static String getChemicalString(Material[] materials, BigDecimal amt) {
        var sb = new StringBuilder();
        var flag = amt.compareTo(BigDecimal.ONE) > 0;

        if (flag)
            sb.append('(');

        for (Material m : materials) {
            sb.append(m);
        }

        if (flag)
            sb.append(')').append(Element.toLoweredString(amt));

        return sb.toString();
    }

    default String getChemicalName() {
        return getChemicalString(getMaterials(), getAmount().getDecimalAmount());
    }

    Material[] getMaterials();

}
