package top.sob.vanilla.util.serialize;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Singleton;
import top.sob.vanilla.annotations.Implementation;

import top.sob.vanilla.annotations.clazz.Builder;

import top.sob.vanilla.util.serialize.raw.RawSerializerBuilder;

import java.util.Objects;

@Implementation(impl = "SerializerProvider")
@Singleton(desc = "Implementation for SerializerProvider", instance = "")
class SerializerProviderImpl extends SerializerProvider {

    private static final SerializerProvider INSTANCE = new SerializerProviderImpl();
    private static final Builder<? extends Serializer> DEFAULT_BUILDER = new RawSerializerBuilder();

    private SerializerProviderImpl() {
    }

    public static SerializerProvider getInstance() {
        return INSTANCE;
    }

    @Override
    public @NotNull Builder<? extends Serializer> getBuilderByName(@NotNull String name) {

        Objects.requireNonNull(name);
        name = name.toUpperCase();

        switch (name) {
            case "IO", "RAW" -> {
                return new RawSerializerBuilder();
            }

            default -> {
                return DEFAULT_BUILDER;
            }
        }

    }

}