import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kitchen {

    Menu menu = Menu.initializeMenu();

    private static boolean isOpened = false;

    private ArrayList<Cooker> cookers = new ArrayList<>();

    public Kitchen(ArrayList<Cooker> cookerss){
        cookers.addAll(cookerss);
    }

    private double decreasedPercentages = checkNumberOfCookers();

    public double getDecreasedPercentages() {
        return decreasedPercentages;
    }

    public void startKitchen(){
        isOpened = true;
        System.out.println("Kitchen is opened");
    }
    public void stopKitchen(){
        isOpened = false;
        System.out.println("Kitchen is closed");
    }
    public double checkNumberOfCookers(){
        return switch (cookers.size()){
            case 1 -> decreasedPercentages = 5000;
            case 2 -> decreasedPercentages = 2600;
            case 3 -> decreasedPercentages = 2100;
            case 4 -> decreasedPercentages = 1600;
            default -> decreasedPercentages = 0;

        };
    }

    public static boolean isOpened() {
        return isOpened;
    }

    public static double getDailyRevenue(ArrayList<Order> oldOrders){
        Double sum = oldOrders.stream()
                .mapToDouble(Order::calculatePrice).sum();
        return sum;
    }




}
