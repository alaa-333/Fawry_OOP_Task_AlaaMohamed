import java.time.LocalDate;

public class Runner {

    public static void main(String[] args) {
        Product   cheese = new Cheese("Romy cheese",2,200,5.55, LocalDate.of(2025, 8, 1));
        Product scratchCard = new ScratchCard(
                "Vodafone Card", 50, 10);

        Product tv = new Tv(
                "TV", 5000, 3, 10);

        Customer customer = new Customer("Alaa", 1000);

      
        Cart cart = new Cart();

        cart.add(cheese, 2);    

        cart.add(scratchCard, 1);  

      
        cart.checkout(customer);

    }
}
