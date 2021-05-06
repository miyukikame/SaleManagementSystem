public class Product {
    private String name, description;
    private double price;
    private int stock;

    //region constructor
    Product(String name, String description, double price, int stock){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    //endregion
    //region getter/setter
    public double getPrice() {
        return price;
    }
    public String getPriceFormatted() {
        return price + "$";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    //endregion
}
