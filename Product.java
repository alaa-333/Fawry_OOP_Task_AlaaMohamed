public abstract class Product {

    protected String name;
    protected int quantity;
    protected double price;

    public Product (String name , int quantity , double price)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean canBuy (int requiredQuantity)
    {
        return quantity >= requiredQuantity && !isExpire();
    }

    public void decreaseQuantity(int qty) {
        this.quantity -= qty;
    }

    public abstract boolean isExpire();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
