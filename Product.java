/**
 * Implementation of Product Class
 *
 * @author Abul Forhad Md Yousuf
 * @version 18/12/2024
 */

public class Product {
    // the attributes
    private String name;
    private int stockLevel;
    private double price;

    // the methods

    // the constructor
    public Product(String nameIn, int stockLevelIn, double priceIn) {
        name = nameIn;
        stockLevel = stockLevelIn;
        price = priceIn;
    }

    // this method allows us to update the stock level
    // and returns the value of stock bought
    public double buyStock(int itemsBought) {
        stockLevel = stockLevel + itemsBought;

        return price * itemsBought;
    }

    // this method allows us to reduce the stock level accordingly
    // and returns true if the sell was successful and false otherwise
    public boolean sell(int itemsSold) {
        if (itemsSold <= stockLevel) {
            stockLevel = stockLevel - itemsSold;

            return true;
        }

        return false;
    }

    // this method allows us to set a new price for the product
    public void setPrice(double newPrice) {
        price = newPrice;
    }

    // this method returns the name of the product
    public String getName() {
        return name;
    }

    // this method returns the stock level
    public int getStockLevel() {
        return stockLevel;
    }

    // this method returns the price of the product
    public double getPrice() {
        return price;
    }
}