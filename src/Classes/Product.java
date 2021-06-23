package Classes;
public class Product {
    private String name;
    private double price;
    private int stock,type;
    //region constructor

    /**
     * constructor which assigns values to the product variables
     * @param name
     * @param price
     * @param stock
     * @param type
     */
    public Product(String name, double price, int stock, int type){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }
    //endregion
    //region getter/setter

    /**
     * returns the price
     * @return price in decimal
     */
    public double getPrice() {
        return price;
    }

    /**
     * returns formatted price
     * @return decimal price with dollar sign appended to it
     */
    public String getPriceFormatted() {
        return price + "$";
    }
    /**
     * returns the name
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the available stock
     * @return product stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * returns the type
     * @return product type
     */
    public int getType() {
        return type;
    }

    /**
     * sets the product name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the product price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * sets the product stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * sets the product type
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    //endregion
}
