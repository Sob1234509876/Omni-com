package top.sob.vanilla.game.storage;

import java.util.Date;

public class GameWideTime {

    private static final GameWideTime INSTANCE = new GameWideTime(0);

    public static final double DEFAULT_MODIFIER = 1.0d / 60000; // 1/60 Hz

    private final double modifier;
    private final long timeShift;

    public GameWideTime(long timeShift) {
        this(DEFAULT_MODIFIER, timeShift);
    }

    public GameWideTime(double modifier, long timeShift) {
        this.modifier = modifier;
        this.timeShift = timeShift;
    }

    public Date getDate() {
        return new Date((long) ((System.currentTimeMillis() - timeShift) * modifier));
    }

}
