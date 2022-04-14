import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Order extends ArrayList<Dish> {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String adress;
    private boolean isOnline;

    public Order( String adress, boolean isOnline) {
        this.adress = adress;
        this.isOnline = isOnline;
        id = count.incrementAndGet();
    }

    public Order( ){
        id = count.incrementAndGet();
        isOnline = false;
    }

    public static double calculatePrice(ArrayList<Dish> dishesOnOrder){
        return dishesOnOrder.stream().mapToDouble(Dish::getPrice).sum();

    }
    public static void showPrice(ArrayList<Dish> dishesOnOrder){
        System.out.println(calculatePrice(dishesOnOrder));
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
}
