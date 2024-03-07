package src.utils.factories;

/**
 * The {@code factory} interface is used for uniting ingame-factories` methods
 * of registering instances or making products.
 * <p>
 * Interfaces of {@code factory} :
 * <p>
 * {@code public Object register();} ———— registering instances into game ID
 * maps and returning the product ID
 * <p>
 * {@code public Object getProduct();} ——— getting the product of the factory
 * without registering into game ID maps
 */

public interface factory {

    public int register();

    public Object getProduct();

}
