public class ScratchCard extends Product

{
    public ScratchCard(String name, int quantity, double price) {
        super(name, quantity, price);
    }

    @Override
    public boolean isExpire() {
        return false;
    }
}
