package math.lib;

/**
 * A geography library with high dimension geography tools.
 * 
 * @version 1.0a
 * @since 0.1a
 */
public class geo {

    /**
     * <i>"A hypercube has 'sides' you know" - the author</i>
     * <p>
     * A recrusion function for cauculating a {@code d} dimension hypercube`s
     * {@code out_d} dimension side
     * <h1>Examples</h1>
     * 
     * <pre>
     * sides(2, 3) = 6   (A cube has 6 square sides)
     * sides(1, 3) = 12 (A cube has 12 edges)
     * sides(0, 3) = 8  (A cube has 8 vertexes)
     * sides(1, 4) = 32 (A tesseract has 36 edges)
     * sides(0, 4) = 16 (A tesseract has 16 vertexes)
     * </pre>
     * 
     * <h1>Formula</h1>
     * 
     * <pre>
     * .
     *                  d
     * sides(o, d) = 2* Σ sides(d-k, o-k-1)  {d > o}
     *                 k=0
     *             = 1                       {d = o}
     * 
     *             = 0                       {d < o}
     * </pre>
     * 
     * @param out_d the dimension of the "sides" of the hypercube
     * @param d     the dimension of the hypercube
     * @use Useful for high dimension machines information cauculation
     * @return The amount of {@code out_d} dimension 'sides' that a {@code d}
     *         hypercube has
     * @since 0.2a
     */
    public static long sides(long out_d, long d) {

        if (d < out_d)
            return 0;
        else if (d == out_d)
            return 1;
        else {
            long tmp = 0;

            for (int i = 0; i <= out_d; i++) {
                tmp += sides(out_d - i, d - i - 1);
            }

            return 2 * tmp;
        }
    }

    /**
     * A function for cauculating the "volume" of the end-game machine - The
     * Heavenly Gate (in {@code d} dimensions)
     * 
     * @param d the dimension of the heavenly gate
     * @return the "volume" of the heavenly gate
     * @since 0.2a
     */
    public static long gate(long d) {
        return 2 * d * (d - 1);
    }
}
