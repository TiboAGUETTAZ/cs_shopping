package ch.csfruits.core;

import ch.csfruits.domain.Fruit;
import ch.csfruits.domain.SpecialOffer;

import java.util.EnumMap;
import java.util.Map;

/**
 * Service to retrieve and add SpecialOffer-s to the system
 */
final public class SpecialOfferServiceLocator {

    // SpecialOffers stored by fruits, not more than 1 specialOffer by fruit allowed
    private static final Map<Fruit, SpecialOffer> specialOffers = new EnumMap<>(Fruit.class);

    private SpecialOfferServiceLocator() {
        // ensure non-instanciation
    }

    public static SpecialOffer getSpecialOffers(Fruit fruit) {
        return specialOffers.get(fruit);
    }

    public static void addSpecialOffer(SpecialOffer specialOffer) {
        specialOffers.put(specialOffer.getFruit(), specialOffer);
    }
}
