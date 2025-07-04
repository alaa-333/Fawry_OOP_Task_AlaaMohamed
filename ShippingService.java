import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("shipment notice");
        for (Shippable s : items) {
            System.out.println(s.getName() + " " + s.getWeight() * 1000 + "g");
            totalWeight += s.getWeight();
        }
        System.out.println("total package weight " + totalWeight + "kg");
    }
}
