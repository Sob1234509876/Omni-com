package top.sob.vanilla.util.serialize;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Creates;
import top.sob.vanilla.annotations.Provider;
import top.sob.vanilla.annotations.clazz.Builder;

@SuppressWarnings("unused")
@Creates(links = "Serializer")
@Provider(defaultProviders = "SerializerProviderImpl")
public abstract class SerializerProvider {

    @NotNull
    public abstract Builder<? extends Serializer> getBuilderByName(@NotNull String name);

}
