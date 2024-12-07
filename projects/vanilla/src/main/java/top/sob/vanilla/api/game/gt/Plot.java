package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.api.devTools.DynamicGInstance;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Plot extends DynamicGInstance implements Placeable {

    private final Type type;
    private final Set<Plot> childrenPlots;
    private final long licenseExpireTime;
    private Set<Player> owners;

    public Plot(@NotNull GTag<?> body, String name, Type type, Set<Plot> children, long licenseExpireTime, Set<Player> owners) {
        super(body, d -> d.toBigInteger().toString(), name);
        this.type = type;
        this.childrenPlots = children;
        this.licenseExpireTime = licenseExpireTime;
        this.owners = owners;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() >= getLicenseExpireTime())
            setOwners(Collections.emptySet());

        throw new WIPException();
    }

    public void setOwners(@NotNull Set<Player> owners) {

        Objects.requireNonNull(owners);

        this.owners = owners;
    }

    @NotNull
    public Set<Player> getOwners() {
        return owners;
    }

    public long getLicenseExpireTime() {
        return licenseExpireTime;
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

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }
}
