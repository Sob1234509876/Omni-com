package vanilla.api;

import java.util.*;

import game.gts.*;

import vanilla.utils.*;

/**
 * All of the items, machines and etc in the players inventory. Maxium amount of GTs: 65536 (2^16)
 * 
 * @since 1.2.7a
 * 
 * @see {@link List}
 * @see {@link Item}
 * @see {@link Element}
 * @see {@link Fluid}
 * @see {@link Material}
 * @see {@link Machine}
 * @see {@link Recipe}
 */
public final class data {

    public static final int MAX_AMOUNT = 65536;

    /**No instance constructing */
    private data() {}

    public static final genericArray<Map.Entry<Item, Long>> Items = new genericArray<>(MAX_AMOUNT);
    public static final genericArray<Map.Entry<Fluid, Long>> Fluids  = new genericArray<>(MAX_AMOUNT);
    public static final genericArray<Map.Entry<Element, Long>> Elements = new genericArray<>(MAX_AMOUNT);
    public static final genericArray<Map.Entry<Material, Long>> Materials = new genericArray<>(MAX_AMOUNT);
    public static final genericArray<Map.Entry<Machine, Long>> Machines = new genericArray<>(MAX_AMOUNT);
    public static final genericArray<Map.Entry<Recipe, Long>> Recipes = new genericArray<>(MAX_AMOUNT);

}
