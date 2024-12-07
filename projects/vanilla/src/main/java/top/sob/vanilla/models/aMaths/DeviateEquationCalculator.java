package top.sob.vanilla.models.aMaths;

import java.math.BigDecimal;

public interface DeviateEquationCalculator {

    BigDecimal calculate(BigDecimal... x);

    int getUnknownAmt();

}
