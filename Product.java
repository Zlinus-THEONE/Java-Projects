public class Product {

    private String name;
    private double price;
    private int stock;

    private int soldUnits;
    private double productRevenue; // How much revenue is made from that specific product


    // How the product is made and added
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.soldUnits =  0;
        this.productRevenue = 0.0;
    }

    // Getter function (In the Main class, when the function is called out, it will return a value)
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getUnitsSold() {
        return soldUnits;
    }

    public double getRevenue() {
        return productRevenue;
    }

    public void recordSale(int quantityPurchased) {
        Product.this.stock -= quantityPurchased;
        Product.this.soldUnits += quantityPurchased;
        Product.this.productRevenue += quantityPurchased * Product.this.price;
    }

}

