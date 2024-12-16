package top.sob.vanilla.models.serialize;

import org.jetbrains.annotations.NotNull;
import top.sob.core.proof.Creates;
import top.sob.vanilla.proof.Provider;
import top.sob.vanilla.utils.misc.Builder;

@SuppressWarnings("unused")
@Creates(links = "Serializer")
@Provider(defaultProviders = "SerializerProviderImpl")
public interface SerializerProvider {

    @NotNull Builder<? extends Serializer> getBuilderByName(@NotNull String name);

}
