package view;



import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private ProductController controller;

    public ConsoleView(ProductController controller) {
        this.controller = controller;
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

