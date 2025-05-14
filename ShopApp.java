/**
 * ShopApp Program
 *
 * @author Abul Forhad Md Yousuf
 * @version 18/12/2024
 */

import java.util.*;
import java.text.DecimalFormat;

public class ShopApp {
    private static Scanner keyboard;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String args[]) {
        keyboard = new Scanner(System.in);

        // declaring an array of 5 objects of the "Product" class
        Product[] productList = new Product[5];

        // initializing the objects
        productList[0] = new Product("Shirts", 50, 49.50);
        productList[1] = new Product("Polo Shirts", 35, 45);
        productList[2] = new Product("Jackets", 25, 89.99);
        productList[3] = new Product("Jeans", 55, 26);
        productList[4] = new Product("Shoes", 45, 65);

        displayAppInfo();

        mainMenu(productList);
    }

    // this method displays the student's information
    static void displayAppInfo() {
        System.out.println("******* ShopApp Program *******");
        System.out.println("Developed by:");
        System.out.println("Student Name: Abul Forhad Md Yousuf");
        System.out.println("Student ID: 2824240");

        System.out.println();
    }

    // this method displays the main menu and allows users to select an option
    static void mainMenu(Product[] productListIn) {
        char response;

        do {
            System.out.println();

            System.out.println("MAIN MENU");
            System.out.println("---------");

            System.out.println();

            System.out.println("[1] Display all products");
            System.out.println("[2] Buy stock");
            System.out.println("[3] Sell stock");
            System.out.println("[4] Re-price a product of stock");
            System.out.println("[5] Display the total value of all stock");
            System.out.println("[6] QUIT PROGRAM");
            System.out.print("Enter choice [1,2,3,4,5,6]: ");
            response = keyboard.next().charAt(0);
            System.out.println();

            switch (response) {
                case '1':
                    displayProducts(productListIn);
                    continue;
                case '2':
                    selectProductToBuy(productListIn);
                    continue;
                case '3':
                    selectProductToSell(productListIn);
                    continue;
                case '4':
                    selectProductToReprice(productListIn);
                    continue;
                case '5':
                    totalValueOfAllStock(productListIn);
                    continue;
                case '6':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Options 1-6 only!");
            }
        } while (response != '6');
    }

    // this method displays all products
    static void displayProducts(Product[] productListIn) {
        System.out.println("*** List of all products ***");
        System.out.println();

        for (int i = 0; i < productListIn.length; i++) {
            System.out.println("Name: " + productListIn[i].getName());
            System.out.println("Stock level: " + productListIn[i].getStockLevel());
            System.out.println("Price: £" + df.format(productListIn[i].getPrice()));

            System.out.println();
        }
    }

    // this method displays the buy menu and allows users to select a product
    static void selectProductToBuy(Product[] productListIn) {
        char response;
        String[] productName = new String[5];

        for (int i = 0; i < productListIn.length; i++) {
            productName[i] = productListIn[i].getName();
        }

        do {
            System.out.println("BUY MENU");
            System.out.println("--------");

            System.out.println();

            System.out.println("Select a product to buy:");
            System.out.println("[1] " + productName[0]);
            System.out.println("[2] " + productName[1]);
            System.out.println("[3] " + productName[2]);
            System.out.println("[4] " + productName[3]);
            System.out.println("[5] " + productName[4]);
            System.out.println("[6] MAIN MENU");

            System.out.print("Enter choice [1,2,3,4,5,6]: ");
            response = keyboard.next().charAt(0);

            switch (response) {
                case '1':
                    quantityOfProductToBuy(productListIn, response);
                    continue;
                case '2':
                    quantityOfProductToBuy(productListIn, response);
                    continue;
                case '3':
                    quantityOfProductToBuy(productListIn, response);
                    continue;
                case '4':
                    quantityOfProductToBuy(productListIn, response);
                    continue;
                case '5':
                    quantityOfProductToBuy(productListIn, response);
                    continue;
                case '6':
                    break;
                default:
                    System.out.println("Options 1-6 only!");
            }
        } while (response != '6');
    }

    // this method allows users to enter quantity, validates input, updates stock level
    // and displays the value of stock bought
    static void quantityOfProductToBuy(Product[] productListIn, char responseIn) {
        int quantity;
        double valueStockBought;

        // input validation for quantity
        do {
            System.out.print("Enter quantity: ");

            while (!keyboard.hasNextInt()) {
                System.out.println("INVALID INPUT!");
                keyboard.next();
                System.out.print("Enter quantity: ");
            }

            quantity = keyboard.nextInt();

            if (quantity <= 0) {
                System.out.println("INVALID INPUT!");
            }
        } while (quantity <= 0);

        if (responseIn == '1') {
            valueStockBought = productListIn[0].buyStock(quantity);
        } else if (responseIn == '2') {
            valueStockBought = productListIn[1].buyStock(quantity);
        } else if (responseIn == '3') {
            valueStockBought = productListIn[2].buyStock(quantity);
        } else if (responseIn == '4') {
            valueStockBought = productListIn[3].buyStock(quantity);
        } else {
            valueStockBought = productListIn[4].buyStock(quantity);
        }

        System.out.println();
        System.out.println("The value of stock bought: " + df.format(valueStockBought));
        System.out.println();
    }

    // this method displays the sell menu and allows users to select a product
    static void selectProductToSell(Product[] productListIn) {
        char response;
        String[] productName = new String[5];

        for (int i = 0; i < productListIn.length; i++) {
            productName[i] = productListIn[i].getName();
        }

        do {
            System.out.println("SELL MENU");
            System.out.println("---------");

            System.out.println();

            System.out.println("Select a product to sell:");
            System.out.println("[1] " + productName[0]);
            System.out.println("[2] " + productName[1]);
            System.out.println("[3] " + productName[2]);
            System.out.println("[4] " + productName[3]);
            System.out.println("[5] " + productName[4]);
            System.out.println("[6] MAIN MENU");

            System.out.print("Enter choice [1,2,3,4,5,6]: ");
            response = keyboard.next().charAt(0);

            switch (response) {
                case '1':
                    quantityOfProductToSell(productListIn, response);
                    continue;
                case '2':
                    quantityOfProductToSell(productListIn, response);
                    continue;
                case '3':
                    quantityOfProductToSell(productListIn, response);
                    continue;
                case '4':
                    quantityOfProductToSell(productListIn, response);
                    continue;
                case '5':
                    quantityOfProductToSell(productListIn, response);
                    continue;
                case '6':
                    break;
                default:
                    System.out.println("Options 1-6 only!");
            }
        } while (response != '6');
    }

    // this method allows users to enter quantity, validates input, updates stock level
    // and displays whether the sell is successful or not
    static void quantityOfProductToSell(Product[] productListIn, char responseIn) {
        int quantity;
        boolean success;

        // input validation for quantity
        do {
            System.out.print("Enter quantity: ");

            while (!keyboard.hasNextInt()) {
                System.out.println("INVALID INPUT!");
                keyboard.next();
                System.out.print("Enter quantity: ");
            }

            quantity = keyboard.nextInt();

            if (quantity <= 0) {
                System.out.println("INVALID INPUT!");
            }
        } while (quantity <= 0);

        if (responseIn == '1') {
            success = productListIn[0].sell(quantity);
        } else if (responseIn == '2') {
            success = productListIn[1].sell(quantity);
        } else if (responseIn == '3') {
            success = productListIn[2].sell(quantity);
        } else if (responseIn == '4') {
            success = productListIn[3].sell(quantity);
        } else {
            success = productListIn[4].sell(quantity);
        }

        if (success) {
            System.out.println("Sell is successful.");
        } else {
            System.out.println("NOT ENOUGH STOCK FOR SELL!");
        }

        System.out.println();
    }

    // this method displays the re-price menu and allows users to select a product
    static void selectProductToReprice(Product[] productListIn) {
        char response;
        String[] productName = new String[5];

        for (int i = 0; i < productListIn.length; i++) {
            productName[i] = productListIn[i].getName();
        }

        do {
            System.out.println("RE-PRICE MENU");
            System.out.println("-------------");

            System.out.println();

            System.out.println("Select a product to re-price:");
            System.out.println("[1] " + productName[0]);
            System.out.println("[2] " + productName[1]);
            System.out.println("[3] " + productName[2]);
            System.out.println("[4] " + productName[3]);
            System.out.println("[5] " + productName[4]);
            System.out.println("[6] MAIN MENU");

            System.out.print("Enter choice [1,2,3,4,5,6]: ");
            response = keyboard.next().charAt(0);

            switch (response) {
                case '1':
                    newPriceOfProduct(productListIn, response);
                    continue;
                case '2':
                    newPriceOfProduct(productListIn, response);
                    continue;
                case '3':
                    newPriceOfProduct(productListIn, response);
                    continue;
                case '4':
                    newPriceOfProduct(productListIn, response);
                    continue;
                case '5':
                    newPriceOfProduct(productListIn, response);
                    continue;
                case '6':
                    break;
                default:
                    System.out.println("Options 1-6 only!");
            }
        } while (response != '6');
    }

    // this method allows users to enter new price, validates input, updates price
    // and displays confirmation
    static void newPriceOfProduct(Product[] productListIn, char responseIn) {
        double newPrice;

        // input validation for new price
        do {
            System.out.print("Enter new price: ");

            while (!keyboard.hasNextDouble()) {
                System.out.println("INVALID INPUT!");
                keyboard.next();
                System.out.print("Enter new price: ");
            }

            newPrice = keyboard.nextDouble();

            if (newPrice <= 0) {
                System.out.println("INVALID INPUT!");
            }
        } while (newPrice <= 0);

        if (responseIn == '1') {
            productListIn[0].setPrice(newPrice);
        } else if (responseIn == '2') {
            productListIn[1].setPrice(newPrice);
        } else if (responseIn == '3') {
            productListIn[2].setPrice(newPrice);
        } else if (responseIn == '4') {
            productListIn[3].setPrice(newPrice);
        } else {
            productListIn[4].setPrice(newPrice);
        }

        System.out.println("The price is updated successfully.");
        System.out.println();
    }

    // this method displays the total value of all stock
    // including the total value of individual stock
    static void totalValueOfAllStock(Product[] productListIn) {
        double grandTotal = 0;

        System.out.println("*** The Total Value of All Stock ***");
        System.out.println();

        for (int i = 0; i < productListIn.length; i++) {
            int stockLevel = productListIn[i].getStockLevel();
            double price = productListIn[i].getPrice();
            double totalValue = stockLevel * price;

            grandTotal = grandTotal + totalValue;

            System.out.println("Name: " + productListIn[i].getName());
            System.out.println("Stock level: " + stockLevel);
            System.out.println("Price: £" + df.format(price));
            System.out.println("Total value: £" + df.format(totalValue));

            System.out.println();
        }

        System.out.println("Grand Total: £" + df.format(grandTotal));
    }
}