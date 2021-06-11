package Classes;
public class Product {
    private String name, description;
    private double price;
    private int stock;
    private int type;
    //region constructor

    /**
     * constructor which assigns values to the product variables
     * @param name
     * @param description
     * @param price
     * @param stock
     * @param type
     */
    public Product(String name, String description, double price, int stock, int type){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.type = type;
    }

    /**
     *
     * @param name
     * @param description
     * @param price
     * @param stock
     */
    public Product(String name, String description, double price, int stock){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
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
     * returns the description
     * @return product description
     */
    public String getDescription() {
        return description;
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
     * sets the product description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
