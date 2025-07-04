import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int qty) {
        if (!product.canBuy(qty))
        {
            System.out.println("not enough quantity or expire");
        }

        items.add(new CartItem(product, qty));
    }

    public double getSubtotal()
    {
        double subtotal = 0.0;

        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }

        return subtotal;

    }

    public double getShippingFees() {
        return items.stream()
                .filter(i -> i.getProduct() instanceof Shippable)
                .mapToDouble(i -> ((Shippable) i.getProduct()).getWeight() * 5)
                .sum();
    }

    public double getTotal() { return getSubtotal() + getShippingFees(); }

    public void checkout(Customer customer) {
        if (items.isEmpty()) throw new IllegalStateException("Cart is empty");
        double total = getTotal();
        if (!customer.canBuy(total)) throw new IllegalStateException("Insufficient balance");

        for (CartItem item : items) {
            if (!item.getProduct().canBuy(item.getQuantity()))
                throw new IllegalStateException("Out of stock or expired");
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        customer.BalanceDeduction(total);
        shipItems();
        printReceipt(customer);
    }

    private void shipItems() {
        List<Shippable> shippableList = items.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof Shippable)
                .map(p -> (Shippable) p)
                .collect(Collectors.toList());

        ShippingService.ship(shippableList);
    }

    private void printReceipt(Customer customer) {
        System.out.println("\ncheckout receipt");

        for (CartItem item : items) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            System.out.printf("%dx %-10s\t%.0f\n", item.getQuantity(), item.getProduct().getName(), itemTotal);
        }

        System.out.println("----------------------");
        System.out.printf("subtotal\t%.0f\n", getSubtotal());
        System.out.printf("shipping\t%.0f\n", getShippingFees());
        System.out.printf("amount\t\t%.0f\n", getTotal());

    }
}
