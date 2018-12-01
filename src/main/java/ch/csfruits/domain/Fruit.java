package ch.csfruits.domain;

import ch.csfruits.util.PriceUtil;

/**
 * Immutable class representing a fruit and its unitaryPriceInPence
 */
public enum Fruit {
    APPLE(35),
    BANANA(20),
    LIME(15),
    MELON(50);

    final private long unitaryPriceInPence;

    Fruit(long defaultUnitaryPriceInPence) {
        unitaryPriceInPence = defaultUnitaryPriceInPence;
    }

    @Override
    public String toString() {
        return super.toString() + " price: " + PriceUtil.getReadablePriceInPounds(unitaryPriceInPence);
    }

    public long getUnitaryPriceInPence() {
        return unitaryPriceInPence;
    }
}
