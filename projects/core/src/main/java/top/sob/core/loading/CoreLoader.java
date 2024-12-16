package top.sob.core.loading;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.moandjiezana.toml.Toml;
import org.jetbrains.annotations.Nullable;
import top.sob.core.api.Plugin;
import top.sob.core.api.Script;
import top.sob.core.Meta;
import top.sob.core.utils.misc.Wrapper;
import top.sob.core.exceptions.ResourceException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class CoreLoader extends URLClassLoader {

    public static final String DEF_META_DIR = "META-INF/meta.toml";

    private final Cache<String, Wrapper<Class<?>>> CACHE = CacheBuilder.newBuilder().build();
    private final Map<String, Toml> METAS;

    {
        var tmp = (Enumeration<URL>) null;
        try {
            tmp = findResources(DEF_META_DIR);
        } catch (IOException e) {
            throw new ResourceException(e);
        }

        var tmp2 = new HashMap<String, Toml>();
        tmp.asIterator().forEachRemaining(url -> {
            try {

                var tmp3 = new Toml().read(new InputStreamReader(url.openStream(), Meta.getDefCharset()));

                var id = tmp3.getString("id");

                tmp2.put(id, tmp3);

            } catch (Throwable ignored) {
            }
        });

        METAS = Map.copyOf(tmp2);
    }

    public CoreLoader(URL[] urls) {
        super(urls);
    }

    @Nullable
    public Wrapper<Class<?>> loadWrappedClass(String id) {
        try {
            return CACHE.get(id, () -> {

                var tmp = METAS.get(id);

                if (tmp == null) throw new ClassNotFoundException("Unknown ID");

                var clazzMain = tmp.getString("MainClass");

                var clazz = loadClass(clazzMain);

                if (clazz.getAnnotation(Plugin.class) != null)
                    return new PluginWrapper(clazz);

                if (clazz.getAnnotation(Script.class) != null)
                    return new ScriptWrapper(clazz);

                return new ClassWrapper(clazz);
            });
        } catch (Throwable e) {
            return null;
        }
    }

    public Map<String, Toml> getMetas() {
        return METAS;
    }

    public Toml getMeta(String id) {
        return getMetas().get(id);
    }

    public Set<String> getAllFoundedID() {
        return METAS.keySet();
    }
}
