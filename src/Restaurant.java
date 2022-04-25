import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Restaurant {
    public static void main(String[] args) {

        Menu menu = Menu.initializeMenu();
        Cooker bob = new Cooker("Bob", "Bobski", 20, 123_456_789, LocalDate.parse("2015-03-06"));

        ArrayList<Order> orders = new ArrayList<>();

//        -----------------------------------------------------------------------------------------------------------------

        Order sobieskiegoOnlineOrder = new Order("Sobieskiego 13/12", true);
        orders.add(sobieskiegoOnlineOrder);
        sobieskiegoOnlineOrder.add(menu.get(1));
        sobieskiegoOnlineOrder.add(menu.get(3));

        Order firstOrder = new Order();
        orders.add(firstOrder);
        firstOrder.add(menu.get(5));firstOrder.add(menu.get(8));

        Order secondOrder = new Order();
        orders.add(secondOrder);
        secondOrder.add(menu.get(4));secondOrder.add(menu.get(6));

        Order thirdOrder = new Order("Niemcewicza 14", true);
        orders.add(secondOrder);
        secondOrder.add(menu.get(4));secondOrder.add(menu.get(6));


//        Order.showPrice(orders.get(1));

        ArrayList<Order> onlineOreders = Order.initializeOnlineOrder(orders);
        ArrayList<Order> stationaryOreders = Order.initializeStationaryOrder(orders);
//        Order.showOrders(stationaryOreders);

        Menu.showMenu(menu);
    }



}

