import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kitchen {

    Menu menu = Menu.initializeMenu();
     double decreasedPercentages = 0;

    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Cooker> cookers = new ArrayList<Cooker>();

    private boolean isOpened = false;

    Kitchen(ArrayList<Employee> emp){
        this.employees = emp;
    }

    public void showEmployee(){
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
    public void startKitchen(){
        isOpened = true;

    }

//    public void  checkNumberOfCookers(){
//        switch (getArrayOfCookers().size()){
//            case 1 -> decreasedPercentages = 1;
//            case 2 -> decreasedPercentages = 1.9;
//            case 3 -> decreasedPercentages = 2.8;
//            case 4 -> decreasedPercentages = 3.8;
//            case 5 -> decreasedPercentages = 4.3;
//            default -> decreasedPercentages = 0;
//
//        };
//    }

}
