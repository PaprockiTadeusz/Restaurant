import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Restaurant {

    static ArrayList<Order> oldOrders = new ArrayList<>();
    static ArrayList<Order> currentOrders = new ArrayList<>();
    static ArrayList<Order> orders = initializeOrders();

    public static void main(String[] args) {

        Menu menu = Menu.initializeMenu();
        ArrayList<Employee> employees = initializeEmployees();

        ArrayList<Order> onlineOrders = new ArrayList<>();
        ArrayList<Order> stationaryOrders = new ArrayList<>();

//        -----------------------------------------------------------------------------------------------------------------

        Kitchen kitchen = new Kitchen(employees);
//        double dp = kit.decreasedPercentages;
        kitchen.startKitchen();

        onlineOrders = getOnlineOrders(orders);
        stationaryOrders = getStationaryOrders(orders);

        currentOrders.addAll(orders);

//        System.out.println(dp);
        startMakingOrders(onlineOrders, stationaryOrders);


    }

    public static void startMakingOrders(ArrayList<Order> stationaryOrders, ArrayList<Order> onlineOrders){

        System.out.println("STARTED MAKING ORDERS \n");
        System.out.println(" --- ONLINE ORDERS --- ");
        onlineOrders.forEach(Order::startMakingOrder);
        System.out.println("\n\n --- STATIONARY ORDERS --- \n\n ");
        stationaryOrders.forEach(Order::startMakingOrder);
        System.out.println("FINISHED MAKING AN ORDERS");
    }

    private static ArrayList<Order> getStationaryOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(Order::isOnline)
                .collect(Collectors.toList());
    }
    private static ArrayList<Order> getOnlineOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(x -> !x.isOnline())
                .collect(Collectors.toList());
    }

    private static ArrayList<Employee> initializeEmployees(){
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

    private static ArrayList<Order> initializeOrders(){
        Menu menu = Menu.initializeMenu();
        ArrayList<Order> orders = new ArrayList<>();

        StationaryOrder firstOrder = new StationaryOrder(false);
        orders.add(firstOrder);
        firstOrder.add(menu.get(5));firstOrder.add(menu.get(8));

        StationaryOrder secondOrder = new StationaryOrder(false);
        orders.add(secondOrder);
        secondOrder.add(menu.get(4));secondOrder.add(menu.get(6));

        OnlineOrder thirdOrder = new OnlineOrder("Niemcewicza 14", true);
        orders.add(thirdOrder);
        thirdOrder.add(menu.get(2));thirdOrder.add(menu.get(6));

        OnlineOrder fourthOrder = new OnlineOrder("Boleslawa Chrobrego 16", true);
        orders.add(fourthOrder);
        fourthOrder.add(menu.get(7));fourthOrder.add(menu.get(3));

        StationaryOrder fifthOrder = new StationaryOrder(false);
        orders.add(fifthOrder);
        fifthOrder.add(menu.get(4));fifthOrder.add(menu.get(9));fifthOrder.add(menu.get(1));

        StationaryOrder sixthOrder = new StationaryOrder(false);
        orders.add(sixthOrder);
        sixthOrder.add(menu.get(4));sixthOrder.add(menu.get(4));
        
        StationaryOrder seventhOrder = new StationaryOrder(false);
        orders.add(seventhOrder);
        seventhOrder.add(menu.get(4));seventhOrder.add(menu.get(4));
        
        StationaryOrder eightOrder = new StationaryOrder(false);
        orders.add(eightOrder);
        eightOrder.add(menu.get(4));eightOrder.add(menu.get(1));eightOrder.add(menu.get(7));eightOrder.add(menu.get(8));eightOrder.add(menu.get(9));

        StationaryOrder ninethOrder = new StationaryOrder(false);
        orders.add(ninethOrder);
        ninethOrder.add(menu.get(4));ninethOrder.add(menu.get(4));

        StationaryOrder tenthOrder = new StationaryOrder(false);
        orders.add(tenthOrder);
        tenthOrder.add(menu.get(6));tenthOrder.add(menu.get(3));tenthOrder.add(menu.get(4));tenthOrder.add(menu.get(4));

        return orders;
    }

    private void addTo(Order order) {
        orders.add(order);
        currentOrders.add(order);

    }

//    private double getDailyRevenue(){
//        return oldOrders.stream()
//                .reduce(0, x -> x.calculatePrice())
//    }

}

