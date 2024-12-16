package top.sob.vanilla.models.market;

import top.sob.vanilla.game.gt.resource.Item;
import top.sob.vanilla.models.aMaths.DeviateEquation;

import java.math.BigDecimal;

public interface Market {

    DeviateEquation getMarketGrowthEquation(Item item);

    default BigDecimal calculate(Item item, BigDecimal... x) {
        return getMarketGrowthEquation(item).calculate(x);
    }

    Item buy(String name, BigDecimal amt);

    Item sell(Item item);

    BigDecimal getValue(String item, BigDecimal amt);

}
