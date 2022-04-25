import java.time.LocalDate;

public class Supplier extends Employee implements EmployeeInterface {
    public Supplier(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
    }

    @Override
    public int getTip() {
        return 0;
    }
}
