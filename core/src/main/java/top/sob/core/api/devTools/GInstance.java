package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.From;
import top.sob.core.annotations.Immutable;
import top.sob.core.api.misc.Wrapper;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;

@Immutable
@From(links = "GConstructor#newInstance(Object...)")
@API(status = API.Status.STABLE, since = "1.2.8a")
public class GInstance extends Wrapper<GTag<?>> {

    private final GType type;

    private BigDecimal amount;
    private final Function<BigDecimal, String> amt2Str;

    @SuppressWarnings("unused")
    public GInstance(@NotNull GTag<?> body, @NotNull GType type, Function<BigDecimal, String> amt2Str) {
        super(body);
        this.type = type;
        this.amt2Str = amt2Str;
    }

    @SuppressWarnings("unused")
    public GInstance(@NotNull GTag<?> body, @NotNull GType type) {
        this(body, type, getDefault2StrFun());
    }

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

    public GType getType() {
        return type;
    }

    public String getAmtStr() {
        return amt2Str.apply(amount);
    }

    @Override
    public String toString() {
        return getType().getNameNDesc() + "\nAmount=" + getAmtStr();
    }
}
