import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Restaurant {
    public static void main(String[] args) {

        Menu menu = Menu.initializeMenu();
        Cooker bob = new Cooker("Bob", "Bobski", 20, 123, LocalDate.parse("2015-03-06"));

        ArrayList<Order> orders = new ArrayList<>();

//        -----------------------------------------------------------------------------------------------------------------

        Order sobieskiegoOnlineOrder = new Order("Sobieskiego 13/12", true);
        orders.add(sobieskiegoOnlineOrder);
        sobieskiegoOnlineOrder.add(menu.get(1));
        sobieskiegoOnlineOrder.add(menu.get(3));

        Order firstStationaryOrder = new Order();
        orders.add(firstStationaryOrder);
        firstStationaryOrder.add(menu.get(5));
        firstStationaryOrder.add(menu.get(8));


        Order.showPrice(orders.get(1));

//        menu.forEach(x -> System.out.println(x.toString()));

        ArrayList<Order> onlineOreders = (ArrayList<Order>) orders.stream().filter(Order::isOnline).collect(Collectors.toList());
        ArrayList<Order> stationaryOreders = (ArrayList<Order>) orders.stream().filter(Order::isNotOnline).collect(Collectors.toList());
        stationaryOreders.forEach(System.out::println);
    }



}

//        ArrayList<Order> stationaryOrders = new ArrayList<>();
//
//        ArrayList<Order> currentOrders = new ArrayList<>();
//        ArrayList<Order> lastOrders = new ArrayList<>();
