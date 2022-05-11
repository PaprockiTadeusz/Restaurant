import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private int telephoneNumber;
    private LocalDate dateOfEmployment;
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int tips;
    private double deliveryTime;

    public Employee(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
        this.dateOfEmployment = dateOfEmployment;
        id = incrementID();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public  boolean isCooker(){
        return this.getClass().getName().equals("Cooker");
    }

    public int giveTip(){
        deliveryTime =(Math.random() * 5);
        if(deliveryTime < 1){
            tips +=
        }
    }

    static ArrayList<Employee> initializeEmployees(){
        ArrayList<Employee> emp = new ArrayList<>();
        Waiter maja = new Waiter("Maja", "Janas", 27, 333_222_111, LocalDate.parse("2016-12-06"));
        Cooker bob = new Cooker("Bob", "Bobski", 20, 123_456_789, LocalDate.parse("2015-03-06"));
        Cooker robert = new Cooker("Robert", "Maklowicz", 58, 123_456_782, LocalDate.parse("2014-03-06"));
        Supplier bartlomiej = new Supplier("Bartlomiej", "Maros", 28, 999_000_111, LocalDate.parse("2019-03-06"));
        emp.add(bob);
        emp.add(robert);
        emp.add(maja);
        emp.add(bartlomiej);

        return emp;
    }

    public static int incrementID(){
        int id = count.incrementAndGet();
        return id;
    }

}
