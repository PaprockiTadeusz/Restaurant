import java.util.ArrayList;
import java.util.stream.Collectors;

public class Restaurant {

    static ArrayList<Order> oldOrders = new ArrayList<>();
    static ArrayList<Order> currentOrders = new ArrayList<>();
    static ArrayList<Order> orders = Order.initializeOrders();


    public static void main(String[] args) {

        Menu menu = Menu.initializeMenu();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Cooker> cookers = Cooker.initializeCookers();
        ArrayList<Supplier> suppliers = Supplier.initializeSuppliers();
        ArrayList<Waiter> waiters = Waiter.initializeWaiters();
        employees.addAll(cookers);
        employees.addAll(suppliers);
        employees.addAll(waiters);


        ArrayList<Order> onlineOrders = new ArrayList<>();
        ArrayList<Order> stationaryOrders = new ArrayList<>();


        Kitchen kitchen = new Kitchen(cookers);

        onlineOrders = Order.getOnlineOrders(orders);
        stationaryOrders = Order.getStationaryOrders(orders);


        currentOrders.addAll(orders);
        consoleClass console = new consoleClass(oldOrders,currentOrders,orders,onlineOrders,stationaryOrders,employees,cookers, waiters, suppliers);
        console.mainMenu();
        currentOrders = console.getCurrentOrders();
        oldOrders = console.getOldOrders();
        orders = console.getOrders();
    }



}

