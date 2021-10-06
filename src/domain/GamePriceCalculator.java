package domain;

import java.io.Serializable;

public class GamePriceCalculator implements PriceCalculation, Serializable {
    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
