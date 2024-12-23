package top.sob.core.api;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.ApiUtils;

import java.util.Locale;

public final class Meta {

    public static final String CORE_CLASS_LOADER_KEY = "coreClassLoader";
    public static final String LANG_KEY = "lang";

    private Meta() {
    }

    @NotNull
    public static ClassLoader getCoreClassLoader() {
        return ApiUtils.getValueBySystem(CORE_CLASS_LOADER_KEY);
    }

    public static Locale getLanguage() {
        return ApiUtils.getValueBySystem(LANG_KEY);
    }

}
