package domain;

import java.io.Serializable;

public abstract class Product implements java.io.Serializable {
    private static int LASTID = 0;
    protected static final long SerialVersionUID = 42L;
    protected PriceCalculation priceCalulator;
    protected String title;
    protected int Id;
    protected String description = "this is a product";
    protected Boolean isInStock = true;

    public Product() {
    }

    public Product(String title) {
        this.title = title;
        LASTID += 1;
        Id = LASTID;
    }

    public Product(String title, int id, String description, Boolean isInStock) {
        this.title = title;
        Id = id;
        this.description = description;
        this.isInStock = isInStock;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInStock(Boolean inStock) {
        isInStock = inStock;
    }

    public void setPriceCalulator(PriceCalculation priceCalulator) {
        this.priceCalulator = priceCalulator;
    }

    public double getPrice(int days) {
        return priceCalulator.getPrice(days);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void lendOut() {
        this.isInStock = false;
    }

    public void bringBack() {
        this.isInStock = true;
    }

    public Boolean getInStock() {
        return isInStock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String show() {
        return "ID: " + Id + "; \tcategorie: " + getClass().getSimpleName() + " ;\ttitle: " + getTitle() + " ;\tdescription: " + getDescription() + "; \tIs in stock: " + getInStock() + "\n";
    }

    @Override
    public abstract String toString();
}
