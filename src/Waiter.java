import java.time.LocalDate;
import java.util.ArrayList;

public class Waiter extends Employee {
    private static boolean isWaiter;
    private static int numberOfRealisedOrders = 0;
    private int tips;
    private double deliveryTime;

    public Waiter(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
        isWaiter = true;
    }
    public static void makeAnOrder(){
        numberOfRealisedOrders++;
    }

    public static int getNumberOfRealisedOrders() {
        return numberOfRealisedOrders;
    }

    public static void setNumberOfRealisedOrders(int numberOfRealisedOrders) {
        Waiter.numberOfRealisedOrders = numberOfRealisedOrders;
    }

    public int getTips() {
        return tips;
    }

    public static ArrayList<Waiter> initializeWaiters() {
        ArrayList<Waiter> waiters = new ArrayList<Waiter>();
        Waiter maja = new Waiter("Maja", "Janas", 27, 333_222_111, LocalDate.parse("2016-12-06"));
        waiters.add(maja);
        return waiters;
    }


    public void giveTip(){
        deliveryTime =(Math.random() * 5);
        if(deliveryTime < 1){
            tips += Math.random() *50;
        } else if(deliveryTime >1 && deliveryTime < 2){
            tips += Math.random() *40;
        }else if(deliveryTime >2 && deliveryTime < 3){
            tips += Math.random() *30;
        }else if(deliveryTime >3 && deliveryTime < 4){
            tips += Math.random() *10;
        } else {
            tips += 0;
        }
        numberOfRealisedOrders++;

    }
}
