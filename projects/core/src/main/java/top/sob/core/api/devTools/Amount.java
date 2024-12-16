package top.sob.core.api.devTools;

import java.math.BigDecimal;

public interface Amount {

    BigDecimal getDecimalAmount();

    Unit getUnit();

    default Amount toDifferentUnit(Unit nu) {
        return getUnit().toDifferentUnit(nu);
    }

}
