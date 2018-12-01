package ch.csfruits.core;

import ch.csfruits.domain.Fruit;

import java.util.List;

public interface Basket {

    Basket addFruit(Fruit fruit);

    long getTotalCost();

    Basket removeFruit(Fruit fruit);

    List<Fruit> getFruitList();
}
