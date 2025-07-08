import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) 
    {
        if (!product.canBuy(quantity)) 
        {
            System.out.println("Product is not available in the requested quantity");
        }
        items.add(new CartItem(product, quantity));
    }

    public double getSubtotal() 
    {
        double subtotal = 0;
        for (CartItem item : items) 
        {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }

 
    public double getShippingFees() 
    {
        double shippingFees = 0;
        for (CartItem item : items) 
        {
            if (item.getProduct() instanceof Shippable) 
            {
                Shippable shippable = (Shippable) item.getProduct();
                shippingFees += shippable.getWeight() * 10; // 10 per kg
            }
        }
        return shippingFees;
    }

  
    public double getTotal() 
    {
        return getSubtotal() + getShippingFees();
    }

   
    public void checkout(Customer customer) 
    {
  
        if (items.isEmpty()) 
        {
            System.out.println("Cannot checkout - cart is empty");
        }

        double total = getTotal();
        if (!customer.canBuy(total)) 
        {
            System.out.println("Cannot checkout or insufficient balance");
        }

        for (CartItem item : items) 
        {
            if (!item.getProduct().canBuy(item.getQuantity())) 
            {
                System.out.println("Item no longer available: " + item.getProduct().getName());
            }
        }

    
        for (CartItem item : items) 
        {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        customer.BalanceDeduction(total);
        shipItems();
        printReceipt(customer);
    }

    private void shipItems() 
    {
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : items) 
        {
            if (item.getProduct() instanceof Shippable) 
            {
                shippableItems.add((Shippable) item.getProduct());
            }
        }
        ShippingService.ship(shippableItems);
    }

   
    private void printReceipt(Customer customer) 
    {
        System.out.println("Receipt for: " + customer.getName());
        System.out.println("Items:");
        for (CartItem item : items) 
        {
            System.out.println("- " + item.getQuantity() + " x " + item.getProduct().getName() +   " @ " + item.getProduct().getPrice());
        }
        System.out.println("Subtotal: " + getSubtotal());
        System.out.println("Shipping: " + getShippingFees());
        System.out.println("Total: " + getTotal());
    }
}