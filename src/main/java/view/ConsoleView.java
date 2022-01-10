package view;



import controller.LagerController;
import controller.ProductController;
import model.LagerAktualisierung;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private ProductController controller;
    private LagerController lagerController;

    public ConsoleView(ProductController controller, LagerController lagerController) {

        this.controller = controller;
        this.lagerController = lagerController;

        controller.add(new Product(1, "Product A", 100, "sku", 10));
        controller.add(new Product(2, "Product B", 100, "sku", 15));


    }

    /**
     * prints the menu with all the possible options for the user
     */
    public void showMenu() {
        System.out.println("""
                    What would you like to do?
                    0. exit
                    1. show products
                    2. add product
                    3. delete product
                    4. update product
                    5. show Lager entries
                    6. add entry
                    7. delete entry
                    8. update entry
                    9. update Lager
                    """);
    }

    public void startConsole() {
        showMenu();
        while (true) {
            System.out.println("Enter input: ");
            Scanner myInput = new Scanner(System.in);
            int option = myInput.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    printProducts(controller.getAll());
                    break;
                case 2:
                    Product product = createProduct();
                    controller.add(product);
                    break;
                case 3:
                    myInput.nextLine();
                    System.out.println("Give product ID: ");
                    int id = myInput.nextInt();
                    controller.deleteById(id);
                    break;
                case 4:
                    controller.update(createProduct());
                    break;
                case 5:
                    printLagerUpdates(lagerController.getAll());
                    break;
                case 9:
                    printProducts(controller.updateLager());
                    break;
                default:
                    System.out.println("Option not valid");
                    startConsole();
            }
            showMenu();
        }
    }

    /**
     * shows all the products in the list given as parameter
     * @param products list of students to be shown
     */
    public void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void printLagerUpdates(List<LagerAktualisierung> entries) {
        for (LagerAktualisierung entry : entries) {
            System.out.println(entry);
        }
    }

    /**
     * creates a product with the attributes given by user
     * @return a new product with the given parameter
     */
    public Product createProduct() {
        Scanner in = new Scanner(System.in);
        System.out.println("Give ID: ");
        int id = in.nextInt();
        System.out.println("Give name: ");
        String name = in.nextLine();
        System.out.println("Give price: ");
        int price = in.nextInt();
        System.out.println("Give sku: ");
        String sku = in.nextLine();
        System.out.println("Give no of units: ");
        int anzahl = in.nextInt();
        return new Product(id, name, price, sku, anzahl);

    }
}

