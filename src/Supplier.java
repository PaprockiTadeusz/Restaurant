import java.time.LocalDate;

public class Supplier extends Employee {
    private static boolean isAvailable = true;
    public Supplier(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
    }

    public static boolean isIsAvailable() {
        return isAvailable;
    }

    public static void setIsAvailable(boolean isAvailable) {
        Supplier.isAvailable = isAvailable;
    }

    public static void Supply(Order dishes) throws InterruptedException {



    }
}