package top.sob.core.utils.misc;

import top.sob.core.annotations.proof.Modifiable;

import java.util.Set;
import java.util.function.Predicate;

public interface Filterable<T> extends Predicate<T> {

    @Modifiable
    Set<Predicate<T>> getFilters();

    @Override
    default boolean test(T t) {

        var flag = new boolean[]{true};

        getFilters().forEach(p -> flag[0] &= p.test(t));

        return flag[0];
    }
}
