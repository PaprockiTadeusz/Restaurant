import java.time.LocalDate;
import java.util.ArrayList;

public class Restaurant {


    public static void main(String[] args) {



        Menu menu = Menu.initializeMenu();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Order> currentOrders = new ArrayList<>();
        ArrayList<Order> oldOrders = new ArrayList<>();


//        -----------------------------------------------------------------------------------------------------------------
        Waiter maja = new Waiter("Maja", "Janas", 27, 333_222_111, LocalDate.parse("2016-12-06"));
        Cooker bob = new Cooker("Bob", "Bobski", 20, 123_456_789, LocalDate.parse("2015-03-06"));
        Cooker robert = new Cooker("Robert", "Maklowicz", 58, 123_456_782, LocalDate.parse("2014-03-06"));
        Supplier szczuru = new Supplier("Szczuru", "?", 120, 2115, LocalDate.parse("2019-03-06"));

        employees.add(bob);
        employees.add(robert);
        employees.add(maja);
        employees.add(szczuru);

        StationaryOrder firstOrder = new StationaryOrder(false);
        orders.add(firstOrder);
        firstOrder.add(menu.get(5));firstOrder.add(menu.get(8));

        StationaryOrder secondOrder = new StationaryOrder(false);
        orders.add(secondOrder);
        secondOrder.add(menu.get(4));secondOrder.add(menu.get(6));

        OnlineOrder thirdOrder = new OnlineOrder("Niemcewicza 14", true);
        orders.add(thirdOrder);
        thirdOrder.add(menu.get(2));thirdOrder.add(menu.get(6));
        
        OnlineOrder thirOrder = new OnlineOrder("Niemcewicza 16", true);
        orders.add(thirOrder);
        thirOrder.add(menu.get(2));thirOrder.add(menu.get(6));

        Order.showOrders(orders);
        Order.showOrderIds(orders);

        Kitchen kit = new Kitchen(employees);
        kit.showEmployee();
//        kit.checkNumberOfCookers();
        System.out.println("Liczba " + kit.decreasedPercentages);

//        firstOrder.startMakingOrder(firstOrder);

    }


}

