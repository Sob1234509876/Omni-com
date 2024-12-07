package top.sob.vanilla.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.Objects;

public final class CommonUtils {

    private static final Unsafe loadedUnsafe;

    static {

        try {
            var field = Unsafe.class.getDeclaredField("theUnsafe");
            loadedUnsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unused")
    @NotNull
    public static Unsafe getUnsafe() {
        return loadedUnsafe;
    }

    @SuppressWarnings("unused")
    public static byte @NotNull [] getBytes(@Nullable Serializable object) throws IOException {
        var stream = new ByteArrayOutputStream();
        var objectOutputStream = new ObjectOutputStream(stream);

        objectOutputStream.writeObject(object);

        return stream.toByteArray();

    }

    @SuppressWarnings("unchecked")
    @NotNull
    public static <T> T requireInstanceOf(@NotNull Object obj, @NotNull Class<T> clazz) {

        Objects.requireNonNull(clazz);
        Objects.requireNonNull(obj);

        @SuppressWarnings("unchecked")
        var tmp = (T) obj;

        return tmp;
    }

}
