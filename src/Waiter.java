import java.time.LocalDate;
import java.util.ArrayList;

public class Waiter extends Employee {
    private static boolean isWaiter;
    private static int numberOfRealisedOrders = 0;

    public Waiter(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
        isWaiter = true;
    }
    public static void makeAnOrder(){
        numberOfRealisedOrders++;
    }

    public static ArrayList<Waiter> initializeWaiters() {
        ArrayList<Waiter> waiters = new ArrayList<Waiter>();
        Waiter maja = new Waiter("Maja", "Janas", 27, 333_222_111, LocalDate.parse("2016-12-06"));
        waiters.add(maja);
        return waiters;
    }
}
