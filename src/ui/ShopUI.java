package ui;

import domain.Shop;

import javax.swing.*;

public class ShopUI {
    Shop shop = new Shop();

    public void start() {
        shop.start();
        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show list of products\n5. Lend a product\n6. check availability\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                ShowAddProduct();
            } else if (choice == 2) {
                showProduct();
            } else if (choice == 3) {
                showPrice();
            } else if (choice == 4) {
                showList();
            } else if (choice == 5) {
                showLendOut();
            } else if (choice == 6) {
                showAvailability();
            } else {
                shop.close();
            }
        }
    }

    private void showAvailability() {
        JOptionPane.showMessageDialog(null, shop.getAvailability());
    }

    private void showLendOut() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Give Id of item you want to lend"));
        shop.lendOut(id);
    }

    private void showList() {
        JOptionPane.showMessageDialog(null, shop.showListOfProducts());
    }

    private void showPrice() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        if (shop.hasProduct(id)) {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.getPrice(id, days));
        }
    }

    private void showProduct() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        String title = shop.showProduct(id);
        JOptionPane.showMessageDialog(null, title);
    }

    private void ShowAddProduct() {
        String title = JOptionPane.showInputDialog("Enter the title:");
        if (shop.hasProductWithTitle(title)) {
            return;
        }
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");
        shop.addProduct(title, type);
    }
}
