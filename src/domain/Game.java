package domain;

import java.io.Serializable;

public class Game extends Product implements Serializable {

    public Game() {
        setPriceCalulator(new GamePriceCalculator());
    }

    public Game(String title) {
        super(title);
        setPriceCalulator(new GamePriceCalculator());
    }

    public Game(String title, int id, String description, Boolean isInStock) {
        super(title, id, description, isInStock);
        setPriceCalulator(new GamePriceCalculator());
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", Id=" + Id +
                ", description='" + description + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
