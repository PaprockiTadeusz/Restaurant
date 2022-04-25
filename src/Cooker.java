import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cooker extends Employee implements EmployeeInterface{
    public Cooker(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
    }

    @Override
    public int getTip() {
        return 0;
    }
}
