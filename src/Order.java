import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Order extends ArrayList<Dish> {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String adress;
    public static double calculatePrice(ArrayList<Dish> dishesOnOrder){
        return dishesOnOrder.stream().mapToDouble(Dish::getPrice).sum();

    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}
