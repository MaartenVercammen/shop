package domain;

import java.util.ArrayList;

public class Shop {
    DB db = new DB();

    public void addProduct(String title, String type) {
        Product product = null;
        switch (type) {
            case "M":
                product = new Movie(title);
                break;
            case "G":
                product = new Game(title);
                break;
            case "C":
                product = new CD(title);
                break;
            default:
                return;
        }
        db.addProduct(product);
    }

    public String showProduct(int id) {
        return db.getProductforId(id).getTitle();
    }

    public boolean hasProduct(int id) {
        return db.hasProduct(id);
    }

    public Object getPrice(int id, int days) {
        return db.getProductforId(id).getPrice(days);
    }

    public boolean hasProductWithTitle(String title) {
        return db.hasProductWithTitle(title);
    }

    public String showListOfProducts() {
        ArrayList<Product> products = db.getOrderdListOfProducts();
        return convertListToString(products);
    }

    public void lendOut(int id) {
        db.getProductforId(id).lendOut();
    }

    public String getAvailability() {
        ArrayList<Product> products = db.getAvailableProducts();
        return convertListToString(products);
    }

    private String convertListToString(ArrayList<Product> list) {
        String out = "";
        for (Product product :
                list) {
            out += product.show();
        }
        return out;
    }

    public void start() {
        db.load();
    }

    public void close() {
        db.save();
    }
}
