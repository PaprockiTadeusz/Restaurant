import java.time.LocalDate;

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
}
