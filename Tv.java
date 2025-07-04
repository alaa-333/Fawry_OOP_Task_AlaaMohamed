public class Tv extends Product implements Shippable
{
    private double weight;


    public Tv(String name, int quantity, double price , double weight)
    {
        super(name, quantity, price);
        this.weight = weight;
    }

    @Override
    public boolean isExpire() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
