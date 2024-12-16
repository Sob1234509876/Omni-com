package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import top.sob.core.proof.From;
import top.sob.core.proof.Modifiable;

import java.util.Set;

@Modifiable
@From(links = "GInstance#getTag()")
@API(status = API.Status.STABLE, since = "1.2.8a")
public interface GTag {

    Set<Object> getChildren();

}
