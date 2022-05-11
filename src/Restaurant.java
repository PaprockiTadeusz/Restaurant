import java.util.ArrayList;
import java.util.stream.Collectors;

public class Restaurant {

    static ArrayList<Order> oldOrders = new ArrayList<>();
    static ArrayList<Order> currentOrders = new ArrayList<>();
    static ArrayList<Order> orders = Order.initializeOrders();


    public static void main(String[] args) {

        Menu menu = Menu.initializeMenu();
        ArrayList<Employee> employees = Employee.initializeEmployees();


        ArrayList<Order> onlineOrders = new ArrayList<>();
        ArrayList<Order> stationaryOrders = new ArrayList<>();


        Kitchen kitchen = new Kitchen(employees);

        onlineOrders = Order.getOnlineOrders(orders);
        stationaryOrders = Order.getStationaryOrders(orders);


        currentOrders.addAll(orders);
        consoleClass console = new consoleClass(oldOrders,currentOrders,orders,onlineOrders,stationaryOrders,employees);
        console.mainMenu();
        currentOrders = console.getCurrentOrders();
        oldOrders = console.getOldOrders();
        orders = console.getOrders();
    }

    private void addTo(Order order) {
        orders.add(order);
        currentOrders.add(order);

    }



}

