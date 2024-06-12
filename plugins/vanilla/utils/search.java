package vanilla.utils;

import java.util.*;
import java.util.Map.*;

import game.gts.*;

/**
 * A util using for searching.
 */
public class search {

    /** No instance constructing */
    private search() {
    }

    /**
     * Searches the first targeted gt of a Reg.
     * 
     * @param <T>  The type of the gt (machine, fluid, etc.).
     * @param name The name of the targeted gt.
     * @param data The Reg you want to search from.
     * @return The targeted gt.
     */
    public static <T extends Item> T SearchReg(String name, List<T> data) {

        for (T i : data) {
            if (i.Name.equals(name)) {
                return i;
            }
        }

        return null;
    }

    /**
     * Returns the amount of GT that a player has.
     * 
     * @param <T>  The type of GT.
     * @param name The name of the GT
     * @param data The inventory.
     * @return The amount of GT in the inventory, if the GT is not defined then it
     *         will return null.
     */
    public static <T extends Item> Long SearchInv(String name, genericArray<Map.Entry<T, Long>> data) {
        try {

            for (int i = 0; i < data.length(); i++) {
                if (data.getElement(i).getKey().Name.equals(name)) { // Find all
                    return data.getElement(i).getValue();
                }
            }

        } catch (NullPointerException e) {
        }

        return null; // Then the GT is not defined.
    }

    /**
     * Set the amount of GT in the inventory to specific value.
     * 
     * @param <T>     The gt type (machine, fluid, etc.).
     * @param keyName The key-name of the targeted entry.
     * @param data    The map or inventory.
     * @param amount  The amount to set.
     * @return The targeted entry.
     */
    public static <T extends Item> void SetInv(String keyName, genericArray<Map.Entry<T, Long>> data, Long amount) {
        Entry<T, Long> E;

        for (int i = 0; i < data.length(); i++) {
            E = data.getElement(i);
            if (E.getKey().Name.equals(keyName)) {
                data.getElement(i).setValue(amount);
                // data.setElement(i, );
                break;
            }

        }
    }

}
