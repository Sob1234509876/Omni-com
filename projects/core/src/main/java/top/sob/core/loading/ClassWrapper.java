package top.sob.core.loading;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;

@API(status = API.Status.INTERNAL, since = "1.2.8a")
public class ClassWrapper extends Wrapper<Class<?>> {

    public ClassWrapper(@NotNull Class<?> body) {
        super(body);
    }

}
