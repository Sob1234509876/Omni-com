package top.sob.vanilla.models.market;

import top.sob.vanilla.models.aMaths.DeviateEquation;

import java.math.BigDecimal;

public interface Market {

    DeviateEquation getMarketGrowthEquation();

    default BigDecimal calculate(BigDecimal... x) {
        return getMarketGrowthEquation().calculate(x);
    }

    BigDecimal calculate(BigDecimal t);
}
