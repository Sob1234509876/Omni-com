package top.sob.core.loaders;

import org.apiguardian.api.API;
import top.sob.core.utils.io.CloseCheck;
import top.sob.core.annotations.proof.From;

import java.io.Closeable;
import java.net.URL;

@From(links = "LoaderProvider#getLoader(URL)")
@API(status = API.Status.STABLE, since = "1.2.8a")
public interface Loader extends Closeable, CloseCheck {

    URL findResource(String name);

}
