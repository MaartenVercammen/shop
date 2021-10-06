package domain;

import java.io.Serializable;

public class MoviePriceCalculator implements PriceCalculation, Serializable {
    @Override
    public double getPrice(int days) {
        int price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            price += (daysLeft * 2);
        }
        return price;
    }
}
