import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class Order extends ArrayList<Dish> {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isOnline;
    private boolean isRealised = false;

    public Order(boolean isOnline) {
        id = incrementID();
        this.isOnline = isOnline;
    }

    public static double calculatePrice(ArrayList<Dish> dishesOnOrder){
        return dishesOnOrder.stream()
                .filter(Dish::isAvailable)
                .mapToDouble(Dish::getPrice)
                .sum();

    }

    public int getId() {
        return id;
    }
    public boolean isOnline() {
        return isOnline;
    }
    public static int incrementID(){
        int id = count.incrementAndGet();
        return id;
    }
    public static void showPrice(ArrayList<Dish> dishesOnOrder){
        System.out.println( calculatePrice(dishesOnOrder));
    }

    public static void showOrders (ArrayList<Order> orders) {
        orders.forEach(System.out::println);
    }
    public static void showOrderIds (ArrayList<Order> orders) {
        orders.stream().map(Order::getId).forEach(System.out::println);
    }

    public boolean isRealised() {
        return isRealised;
    }

    public void startMakingOrder(Order order){
        order.stream()
                .forEach(Dish::startMakingDish);
    }
}
