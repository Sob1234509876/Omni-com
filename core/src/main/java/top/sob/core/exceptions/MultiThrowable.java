package top.sob.core.exceptions;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.core.annotations.Mutable;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

@Mutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class MultiThrowable extends Throwable {

    private final LinkedList<Throwable> throwable = new LinkedList<>();

    public MultiThrowable() {
        this(null);
    }

    public MultiThrowable(@Nullable String m) {
        this(m, new Throwable[0]);
    }

    public MultiThrowable(@Nullable String m, @NotNull Throwable[] throwable) {
        this(m, Arrays.asList(throwable));
    }

    public MultiThrowable(@Nullable String m, @NotNull Collection<Throwable> throwable) {
        super(m);

        Objects.requireNonNull(throwable);

        this.throwable.addAll(throwable);
    }

    public void addThrowable(@NotNull Throwable throwable) {
        Objects.requireNonNull(throwable);

        this.throwable.add(throwable);
    }

    @SuppressWarnings("unused")
    public boolean addThrowable(@NotNull Throwable[] throwable) {
        return addThrowable(Arrays.asList(throwable));
    }

    public boolean addThrowable(@NotNull Collection<Throwable> throwable) {
        Objects.requireNonNull(throwable);

        return this.throwable.addAll(throwable);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);

        throwable.stream().filter(Objects::nonNull).forEach((t) -> {
            s.println();
            t.printStackTrace(s);
        });

    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);

        throwable.stream().filter(Objects::nonNull).forEach((t) -> {
            s.println();
            t.printStackTrace(s);
        });

    }

    public List<Throwable> getThrowable() {
        return throwable;
    }

    @Override
    public synchronized String getMessage() {
        var sb = new StringBuilder();

        sb.append(super.getMessage() == null ? "" : super.getMessage()).append('\n');

        throwable.stream().filter(Objects::nonNull).forEach((t) -> sb.append("* ").append(t.getMessage() == null ? "" : t.getMessage()).append('\n'));

        return sb.toString();
    }
}
