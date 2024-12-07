package top.sob.vanilla.api.game.gt;

import java.math.BigDecimal;

public interface Entity extends Runnable {

    void setAliveness(boolean b);

    boolean isAliveness();

    void setHp(BigDecimal hp);

    BigDecimal getHp();

    void uponDeath();

}