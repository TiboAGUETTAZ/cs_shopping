package ch.csfruits.util;

/**
 * Utility class providing price related convenience methods
 */
final public class PriceUtil {

    private PriceUtil() {
        // ensure non-instanciability
    }

    /**
     * Return a readable string representing the price in £ of the price in pence received as a parameter.
     * Ex: the return string for a pence price of "150" will be: "1.50£"
     * @param pencePrice the price in pence to convert into £
     * @return a String describing the price in £
     */
    public static String getReadablePriceInPounds(long pencePrice) {
        long pounds = pencePrice / 100L;
        long pence = pencePrice % 100L;
        return pounds + "." + pence + "£";
    }
}
