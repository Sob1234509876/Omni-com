package Codes.Factories;

/**
 * The {@code factory} interface is used for uniting ingame-factories` methods
 * of registering instances or making products.
 * <p>
 * Interfaces of {@code factory} :
 * <p>
 * {@code public Object register();} ———— registering instances into game ID maps and returning the product of the factory<p>
 * {@code public Object getProduct();} ——— getting the product of the factory without registering into game ID maps
 */

public interface factory {

    public Object register();
    public Object getProduct();

}
