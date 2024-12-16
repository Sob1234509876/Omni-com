package top.sob.vanilla.game.gt.abs;

import top.sob.core.api.devTools.Amount;

import java.math.BigDecimal;

public interface Entity extends Runnable {

    void setAliveness(boolean b);

    boolean isAliveness();

    void setHp(BigDecimal hp);

    Amount getHp();

    void uponDeath();

}