package math.utils;

/**
 * Provides some useful tools to cauculate physic and thermal dynamics (and
 * etc.)
 */

public class util {

    /**
     * 
     * A tool for cauculating the time needed for the temperature ratio reaches the
     * <p>
     * targetted ratio.
     * <p>
     * The default heat transefer rate of the matter is set to 0.5
     * 
     * @param o the outside temperature
     * @param i the inside temperature
     * @param t the targeted ratio of i:o
     * @return the time needed for the heat to reach the targeted ratio
     * @since 0.1a
     */

    public static double h(double o, double i, double t) {
        return -Math.log(1 - t)
                / Math.log(0.5);
    }

    /**
     * A tool for cauculating the time needed for the temperature ratio reaches the
     * <p>
     * targetted ratio.
     * 
     * @param o  the outside temperature
     * @param i  the inside temperature
     * @param t  the targeted ratio of i:o
     * @param tr the heat transfer rate of the matter (in-game unit)
     * @return the time needed for the heat to reach the targeted ratio
     * @since 0.1a
     */

    public static double h(double o, double i, double t, double tr) {
        return -Math.log(1 - t)
                / Math.log(1 - tr);
    }

    /**
     * 
     * A tool to smooth your numbers.
     * <p>
     * Also could be used as a in-game heat transfer rate and real-life heat
     * <p>
     * transfer rate convertor (Because I`m lazy)
     * 
     * @param x the number to smooth
     * @return 1/(1+e^-x)
     * @since 0.1a
     */

    public static double s(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
