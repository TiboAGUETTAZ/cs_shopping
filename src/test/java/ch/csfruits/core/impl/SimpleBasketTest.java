package ch.csfruits.core.impl;

import ch.csfruits.core.Basket;
import ch.csfruits.core.SpecialOfferServiceLocator;
import ch.csfruits.domain.SpecialOffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static ch.csfruits.domain.Fruit.*;

public class SimpleBasketTest {


    @Before
    public void setUpOffers() {
        SpecialOfferServiceLocator.addSpecialOffer(new SpecialOffer(MELON, 2, 1));
        SpecialOfferServiceLocator.addSpecialOffer(new SpecialOffer(LIME, 3, 2));
    }

    @Test
    public void addFirstFruitIntoBasketTest() {
        Basket basket = new SimpleBasket();
        basket.addFruit(APPLE);
        assertEquals(35, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(BANANA);
        assertEquals(20, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(MELON);
        assertEquals(50, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(LIME);
        assertEquals(15, basket.getTotalCost());
    }

    @Test
    public void addingOtherFruitTest() {
        Basket basket = new SimpleBasket();
        basket.addFruit(APPLE).addFruit(APPLE);
        assertEquals(70, basket.getTotalCost());
        basket.addFruit(APPLE);
        assertEquals(105, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(APPLE).addFruit(BANANA);
        assertEquals(55, basket.getTotalCost());
        basket.addFruit(BANANA);
        assertEquals(75, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(APPLE);
        assertEquals(35, basket.getTotalCost());
        basket.addFruit(MELON);
        assertEquals(85, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(APPLE).addFruit(MELON);
        assertEquals(85, basket.getTotalCost());
        basket.addFruit(MELON);
        assertEquals(85, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(LIME).addFruit(LIME).addFruit(MELON).addFruit(MELON);
        assertEquals(80, basket.getTotalCost());
        basket.addFruit(LIME);
        assertEquals(80, basket.getTotalCost());

        basket = new SimpleBasket();
        basket.addFruit(LIME).addFruit(LIME).addFruit(LIME).addFruit(MELON).addFruit(MELON);
        assertEquals(80, basket.getTotalCost());
        basket.addFruit(LIME);
        assertEquals(95, basket.getTotalCost());
    }


}
