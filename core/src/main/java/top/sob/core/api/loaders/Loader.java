package top.sob.core.api.loaders;

import org.apiguardian.api.API;
import top.sob.core.api.CloseCheck;
import top.sob.core.annotations.From;

import java.io.Closeable;
import java.net.URL;

@From(links = "LoaderProvider#getLoader(URL)")
@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class Loader implements Closeable, CloseCheck {

    public abstract URL findResource(String name);

}
