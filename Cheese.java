import java.time.LocalDate;

public class Cheese extends Product implements ShippablePerishableProduct
{

    private double weight;
    private LocalDate expiryDate;

    public Cheese(String name, int quantity, double price ,double weight , LocalDate expiryDate )
    {
        super(name, quantity, price);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    public double getWeight() { return weight; }

    @Override
    public boolean isExpire() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public String getName() { return name; }

}
