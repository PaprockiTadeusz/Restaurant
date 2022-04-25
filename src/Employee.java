import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private int telephoneNumber;
    private LocalDate dateOfEmployment;
    private int tips;

    public Employee(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", telephoneNumber=" + telephoneNumber +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}
