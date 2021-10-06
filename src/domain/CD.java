package domain;

import java.io.Serializable;

public class CD extends Product implements Serializable {

    public CD() {
        setPriceCalulator(new CDPriceCalculator());
    }

    public CD(String title) {
        super(title);
        setPriceCalulator(new CDPriceCalculator());
    }

    public CD(String title, int id, String description, Boolean isInStock) {
        super(title, id, description, isInStock);
        setPriceCalulator(new CDPriceCalculator());
    }

    @Override
    public String toString() {
        return "CD{" +
                "title='" + title + '\'' +
                ", Id=" + Id +
                ", description='" + description + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
