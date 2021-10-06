package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class BasicFormatter implements DataFormater {
    @Override
    public String format(ArrayList<Product> products) {
        StringBuilder out = new StringBuilder();
        for (Product product : products) {
            out.append(product.getClass().getSimpleName()).append("|").append(product.getTitle()).append("|").append(product.getDescription()).append("|").append(product.getInStock()).append("|").append(product.getId()).append("\n");
        }
        return out.toString();
    }

    @Override
    public ArrayList<Product> deformat(BufferedReader reader) {
        ArrayList<Product> products = new ArrayList<>();
        String line = null;
        try {
            line = reader.readLine();
            while (line != null) {
                String[] lineElements = line.split("\\|");
                String type = lineElements[0];
                Product product = (Product) Class.forName("domain." + type).newInstance();
                product.setTitle(lineElements[1]);
                product.setDescription(lineElements[2]);
                product.setInStock(Boolean.parseBoolean(lineElements[3]));
                product.setId(Integer.parseInt(lineElements[4]));
                products.add(product);
                line = reader.readLine();
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            return new ArrayList<>();
        }
        return products;
    }
}
