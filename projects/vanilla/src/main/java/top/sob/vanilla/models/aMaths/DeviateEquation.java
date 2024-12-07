package top.sob.vanilla.models.aMaths;

import java.math.BigDecimal;

public interface DeviateEquation {

    DeviateEquationCalculator getCalculator();

    default BigDecimal calculate(BigDecimal... x) {
        return getCalculator().calculate(x);
    }

    BigDecimal getDeviate(BigDecimal... x);

}
