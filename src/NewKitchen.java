import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewKitchen {

    Menu menu = Menu.initializeMenu();
    static double decreasedPercentages = 0;

    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Employee> cookerArray = initialzeCookerArray(employees);

    private boolean isOpened = false;
    NewKitchen(ArrayList<Employee> emp){
        this.employees = emp;
    }
    public void showEmployee(){
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
    public ArrayList<Employee> initialzeCookerArray(ArrayList<Employee> employees){
        List<Employee> collect = employees.stream()
                .filter(x -> x.getClass().equals(Cooker.class))
                .collect(Collectors.toList());
        return (ArrayList<Employee>) collect;
    }

    public void startKitchen(){
        isOpened = true;

    }


    public static void setDecreasedPercentages(double decreasedPercentages) {
        Kitchen.decreasedPercentages = decreasedPercentages;
    }

    public ArrayList<Employee> getArrayOfCookers() {
        return cookerArray;
    }



    public double checkNumberOfCookers(){
        double a = switch (getArrayOfCookers().size()){
            case 1 -> decreasedPercentages = 1;
            case 2 -> decreasedPercentages = 1.9;
            case 3 -> decreasedPercentages = 2.8;
            case 4 -> decreasedPercentages = 3.8;
            case 5 -> decreasedPercentages = 4.3;
            default -> decreasedPercentages = 0;

        };
        return a;
    }

}
