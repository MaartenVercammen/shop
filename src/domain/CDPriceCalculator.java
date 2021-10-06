package domain;

import java.io.Serializable;

public class CDPriceCalculator implements PriceCalculation, Serializable {
    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }
}
