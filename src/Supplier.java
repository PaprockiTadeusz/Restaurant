import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public static void Supply(ArrayList<Supplier> suppliers, Order order) throws InterruptedException {
        long time = 0;
        switch(suppliers.size()) {
           case 1 -> time =5000;
           case 2 -> time =2500;
           case 3 -> time =1667;
//           default ->
        }
        SupplierThread sp = new SupplierThread();
            sp.run(time);
        }


    public static ArrayList<Supplier> initializeSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        Supplier bartlomiej = new Supplier("Bartlomiej", "Maros", 28, 999_000_111, LocalDate.parse("2019-03-06"));
        suppliers.add(bartlomiej);
        return suppliers;
    }
}