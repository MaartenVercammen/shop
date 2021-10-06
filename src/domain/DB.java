package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DB {
    private ArrayList<Product> products = new ArrayList<>();
    private final String FILEPATH = "save.txt";

    public Product getProductforId(int id) {
        for (Product product :
                products) {
            if (product.Id == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (products.stream().anyMatch(p -> p.Id == product.Id)) {
            return;
        }

        products.add(product);
    }

    public boolean hasProduct(int id) {
        return products.stream().anyMatch(p -> p.Id == id);
    }

    public boolean hasProductWithTitle(String title) {
        if (products.size() == 0) {
            return false;
        }
        return products.stream().anyMatch(p -> p.getTitle().equals(title));
    }

    public ArrayList<Product> getOrderdListOfProducts() {
        products.sort(new OrderListByClass());
        return products;
    }

    public ArrayList<Product> getAvailableProducts() {
        return products.stream().filter(Product::getInStock).collect(Collectors.toCollection(ArrayList::new));
    }

    public void save() {
        try (FileWriter writer = new FileWriter(FILEPATH)) {
            writer.write("");
            DataFormater formater = new BasicFormatter();
            String formattedData = formater.format(products);
            writer.write(formattedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            DataFormater formater = new BasicFormatter();
            products = formater.deformat(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}