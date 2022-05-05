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

    public double calculatePrice(){
        return this.stream()
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

    public void deleteById(){
        Restaurant.currentOrders
                .removeIf(x -> x.getId() == this.getId());
    }

    public void showPrice(ArrayList<Dish> dishesOnOrder){
        System.out.println( calculatePrice());
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

    public void startMakingOrder(){
        System.out.println("# Started making an order: " + getId());
        System.out.println(isOnline ? "# Online Order" : "# Stationary Order");
            this.stream()
                    .forEach(this::isAvailableIfNotThrowException);
        System.out.println("$ Final Price is: " + this.calculatePrice() + "\n# Finished making an order: "+ getId() + "\n -------------------------------");
        Restaurant.oldOrders.add(this);
        deleteById();


    }

    private void isAvailableIfNotThrowException(Dish x) {
        if (x.isAvailable())
        {
            x.startMakingDish();

//            System.out.println("czesc");
    }
        else{
            x.skip();
            try {
                System.out.println("!!!Order with not available dish !!!");
                throw new NotAvailableException("Dish: " + x.getName() + " is not available");
            } catch (NotAvailableException e) {
            }
        }
    }

}
