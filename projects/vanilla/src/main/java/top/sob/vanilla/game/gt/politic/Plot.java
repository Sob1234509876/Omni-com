package top.sob.vanilla.game.gt.politic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.game.gt.abs.Placeable;
import top.sob.vanilla.game.gt.Player;
import top.sob.vanilla.proof.WIPException;

import java.util.Collections;
import java.util.Set;

public class Plot extends Property implements Placeable {

    private final Type type;
    private final Set<Plot> childrenPlots;

    public Plot(@NotNull GTag<?> body, String name, Type type, Set<Plot> children, long licenseExpireTime, Set<Player> owners) {
        super(body, d -> d.toBigInteger().toString(), name);
        this.type = type;
        this.childrenPlots = children;
    }

    @Override
    public void run() {
        throw new WIPException();
    }

    @Unmodifiable
    @NotNull
    public Set<Plot> getChildrenPlots() {
        return Collections.unmodifiableSet(childrenPlots);
    }

    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    public boolean needLicense() {
        throw new WIPException();
    }

    @Override
    public @Nullable License getLicense() {
        throw new WIPException();
    }

    /**
     * The types of plots are based on the original chain of TOH (The Official Hierarchy) of All Dimensions. You can ask
     * yourself "How do I add all the contents to these dimensions without using drugs or blah blah blah?".
     */
    @SuppressWarnings("unused")
    public enum Type {
        ATOMIC,
        BUILDING,
        AREA,
        COUNTRY,
        CONTINENT,
        PLANET,
        SOLAR_SYSTEM,
        SYSTEM_CLUSTER,
        GALACTIC_SPIRAL_ARM,
        GALAXY,
        GALAXY_CLUSTER,
        GALAXY_SUPER_CLUSTER,
        GALAXY_GREAT_WALL,
        UNIVERSE,
        UNIVERSE_GROUP,
        UNIVERSE_HYPER_GROUP,
        UNIVERSE_SUPER_GROUP,
        NULTIVERSE,
        MULTIVERSE,
        METAVERSE,
        XENOVERSE,
        HYPERVERSE,
        KILOVERSE,
        MEGAVERSE,
        GIGAVERSE,
        TERAVERSE,
        PETAVERSE,
        EXAVERSE,
        ZETTAVERSE,
        YOTTAVERSE,
        RONNAVERSE,
        QUETTAVERSE,
        EDA,
        HENDAVERSE,
        DOCKAVERSE,
        ARCHVERSE,
        ULTRAVERSE,
        OMNIVERSE
    }

}
