package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;

@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class GInstance extends Wrapper<GTag<?>> {

    private BigDecimal amount;
    private final Function<BigDecimal, String> amt2Str;
    private final String name;

    public GInstance(@NotNull GTag<?> body, Function<BigDecimal, String> amt2Str, String name) {
        super(body);
        this.amt2Str = amt2Str;
        this.name = name;
    }

    public GInstance(@NotNull GTag<?> body, String name) {
        this(body, getDefault2StrFun(), name);
    }

    public abstract Painter<GInstance> getPainter();

    public static Function<BigDecimal, String> getDefault2StrFun() {
        return Objects::toString;
    }

    @SuppressWarnings("unused")
    public BigDecimal getAmount() {
        return amount;
    }

    @SuppressWarnings("unused")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmtStr() {
        return amt2Str.apply(amount);
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return amt2Str.apply(amount) + " " + getName();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GInstance gInstance)) return false;
        return Objects.equals(getAmount(), gInstance.getAmount()) && Objects.equals(amt2Str, gInstance.amt2Str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), amt2Str);
    }
}
