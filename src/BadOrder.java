import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BadOrder extends ArrayList<Dish> {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String adress;
    private boolean isOnline;
    private LocalDateTime dateOfOreder;
    private boolean isFinished;

    public BadOrder(String adress, boolean isOnline) {
        this.adress = adress;
        this.isOnline = isOnline;
        id = count.incrementAndGet();
        dateOfOreder = LocalDateTime.now();
    }

    public BadOrder( ){
        id = count.incrementAndGet();
        isOnline = false;
        dateOfOreder = LocalDateTime.now();
    }
    public LocalDateTime getDateOfOreder() {
        return dateOfOreder;
    }

    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public static double calculatePrice(ArrayList<Dish> dishesOnOrder){
        return dishesOnOrder.stream()
                .mapToDouble(Dish::getPrice)
                .sum();

    }
    public static void showPrice(ArrayList<Dish> dishesOnOrder){
        System.out.println( calculatePrice(dishesOnOrder));
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isOnline() {
        return isOnline;
    }
    public boolean isNotOnline() {
        return !isOnline;
    }

    public static ArrayList<BadOrder> initializeOnlineOrder (ArrayList<BadOrder> orders) {
        return (ArrayList<BadOrder>) orders.stream()
                .filter(BadOrder::isOnline)
                .collect(Collectors.toList());
    }

    public static ArrayList<BadOrder> initializeStationaryOrder (ArrayList<BadOrder> orders) {
        return (ArrayList<BadOrder>) orders.stream()
                .filter(BadOrder::isNotOnline)
                .collect(Collectors.toList());
    }
    public static void showOrders (ArrayList<BadOrder> orders) {
        orders.forEach(System.out::println);
    }


}