import java.time.LocalDate;
import java.time.LocalDateTime;

public class Supplier extends Employee {
    public Supplier(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
    }
}
