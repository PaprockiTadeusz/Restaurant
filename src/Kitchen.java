import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Kitchen {
    Menu menu = Menu.initializeMenu();
    static double decreasedPercentages = 0;
    private boolean isOpened = false;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Employee> arrayOfCookers = initialzeCookerArray(employees);
    ArrayList<Employee> arrayOfWaiters = initialzeWaiterArray(employees);
    ArrayList<Employee> arrayOfSuppliers = initialzeSupplierArray(employees);


    Kitchen(ArrayList<Employee> emp){
        this.employees = emp;
    }

    public void startKitchen(){
        isOpened = true;

    }

    public ArrayList<Employee> getArrayOfCookers() {
        return arrayOfCookers;
    }


    public static void setDecreasedPercentages(double decreasedPercentages) {
        Kitchen.decreasedPercentages = decreasedPercentages;
    }

    public static double getDecreasedPercentages() {
        return decreasedPercentages;
    }

    public ArrayList<Employee> initialzeCookerArray(ArrayList<Employee> employees){
        List<Employee> collect = employees.stream()
                .filter(x -> x.getClass().equals(Cooker.class))
                .collect(Collectors.toList());
        return (ArrayList<Employee>) collect;
    }
    public ArrayList<Employee> initialzeWaiterArray(ArrayList<Employee> employees){
        List<Employee> collect = employees.stream()
                .filter(x -> x.getClass().equals(Waiter.class))
                .collect(Collectors.toList());
        return (ArrayList<Employee>) collect;
    }
    public ArrayList<Employee> initialzeSupplierArray(ArrayList<Employee> employees){
        List<Employee> collect = employees.stream()
                .filter(x -> x.getClass().equals(Supplier.class))
                .collect(Collectors.toList());
        return (ArrayList<Employee>) collect;
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
