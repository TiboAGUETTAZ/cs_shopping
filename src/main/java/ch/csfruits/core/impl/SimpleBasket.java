package ch.csfruits.core.impl;

import ch.csfruits.core.Basket;
import ch.csfruits.core.SpecialOfferServiceLocator;
import ch.csfruits.domain.Fruit;
import ch.csfruits.domain.SpecialOffer;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


// Not thread-safe
final public class SimpleBasket implements Basket {

    private final Map<Fruit, Integer> quantityByFruit = new EnumMap<>(Fruit.class);

    @Override
    public Basket addFruit(Fruit fruit) {
        Integer quantityForFruit = quantityByFruit.get(fruit);
        if (quantityForFruit == null) {
            quantityForFruit = 0; // Auto-boxing
        }
        quantityByFruit.put(fruit, ++quantityForFruit);
        return this;
    }

    @Override
    public long getTotalCost() {
        long total = 0;
        for (Map.Entry<Fruit, Integer> entry : quantityByFruit.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            if (quantity > 0) {
                SpecialOffer specialOffer = SpecialOfferServiceLocator.getSpecialOffers(fruit);
                if (specialOffer != null) {
                    int offerAppliedTimes = quantity / specialOffer.getNumberBought();
                    int fruitsOutsideOfOffers = quantity % specialOffer.getNumberBought();
                    total += fruit.getUnitaryPriceInPence() * (fruitsOutsideOfOffers + offerAppliedTimes * specialOffer.getNumberPaid());
                } else {
                    total += fruit.getUnitaryPriceInPence() * quantity;
                }
            }
        }
        return total;
    }


    @Override
    public Basket removeFruit(Fruit fruit) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

    @Override
    public List<Fruit> getFruitList()  {
        throw new UnsupportedOperationException("Not yet Implemented");
    }
}
