package top.sob.vanilla.models.market;

import java.math.BigDecimal;

public interface SimpleMarket extends Market {

    @Override
    default BigDecimal calculate(BigDecimal... t) {

        if (t.length != 1)
            throw new ArrayIndexOutOfBoundsException("Input size is not 1");

        return Market.super.calculate(t);
    }
}
