package Employees;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cooker extends Employee {
    private boolean isCooker = true;
    public Cooker(String name, String surname, int age, int telephoneNumber, LocalDate dateOfEmployment) {
        super(name, surname, age, telephoneNumber, dateOfEmployment);
    }

    @Override
    public boolean isCooker() {
        return isCooker;
    }

    public static ArrayList<Cooker> initializeCookers() {
        ArrayList<Cooker> cookers = new ArrayList<Cooker>();
        Cooker bob = new Cooker("Bob", "Bobski", 20, 123_456_789, LocalDate.parse("2015-03-06"));
        Cooker robert = new Cooker("Robert", "Maklowicz", 58, 123_456_782, LocalDate.parse("2014-03-06"));
        cookers.add(bob);
        cookers.add(robert);
        return cookers;
    }
}
