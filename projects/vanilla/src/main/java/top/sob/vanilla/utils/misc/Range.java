package top.sob.vanilla.utils.misc;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Predicate;

public record Range<T>(boolean leftRangeOpen, boolean rightRangeOpen, Comparable<T> leftRange,
                       Comparable<T> rightRange) implements Predicate<T> {

    public Range(boolean leftRangeOpen, boolean rightRangeOpen, @NotNull Comparable<T> leftRange, @NotNull Comparable<T> rightRange) {

        Objects.requireNonNull(leftRange);
        Objects.requireNonNull(rightRange);

        this.leftRangeOpen = leftRangeOpen;
        this.rightRangeOpen = rightRangeOpen;
        this.leftRange = leftRange;
        this.rightRange = rightRange;
    }

    public boolean inRange(T t) {

        var l = leftRange().compareTo(t);
        var r = rightRange().compareTo(t);
        var tmp = true;

        if (leftRangeOpen())
            tmp &= l >= 0;
        else
            tmp &= l > 0;

        if (rightRangeOpen())
            tmp &= r <= 0;
        else
            tmp &= r < 0;

        return tmp;
    }

    @Override
    public boolean test(T t) {
        return inRange(t);
    }

    @Override
    public String toString() {
        return (leftRangeOpen() ? '[' : '(') +
                leftRange().getClass().getName() +
                ", " +
                rightRange().getClass().getName() +
                (rightRangeOpen() ? ']' : ')');
    }
}
