package domain;

import java.io.Serializable;

public class Movie extends Product implements Serializable {

    public Movie() {
        setPriceCalulator(new MoviePriceCalculator());
    }

    public Movie(String title) {
        super(title);
        setPriceCalulator(new MoviePriceCalculator());
    }

    public Movie(String title, int id, String description, Boolean isInStock) {
        super(title, id, description, isInStock);
        setPriceCalulator(new MoviePriceCalculator());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", Id=" + Id +
                ", description='" + description + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
