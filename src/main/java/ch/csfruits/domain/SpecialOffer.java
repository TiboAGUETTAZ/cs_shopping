package ch.csfruits.domain;

import java.util.Objects;


/**
 * ch.csfruits.domain.SpecialOffer is immutable
 */
final public class SpecialOffer {

    private final Fruit fruit;

    // exact number of fruits to trigger the offer
    private final int numberBought;

    // number of fruit effectively paid
    private final int numberPaid;

    public SpecialOffer(Fruit fruit, int numberBought, int numberPaid) {
        // Some basic check to ensure the validity of the offer
        Objects.requireNonNull(fruit);
        if (numberBought < 1 || numberPaid < 1 || numberBought <= numberPaid) {
            throw new IllegalArgumentException("Invalid Special offer for fruit " + fruit
                    + " numberBought=" + numberBought + " numberPaid=" + numberPaid);
        }
        this.fruit = fruit;
        this.numberBought = numberBought;
        this.numberPaid = numberPaid;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Special Offer on ").append(fruit.name()).append(": ");
        if (numberBought == 2 && numberPaid == 1) {
            stringBuilder.append("buy 1 get 1 free");
        } else {
            stringBuilder.append(numberBought).append(" for the price of ").append(numberPaid);
        }
        return stringBuilder.toString();
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getNumberBought() {
        return numberBought;
    }

    public int getNumberPaid() {
        return numberPaid;
    }
}
