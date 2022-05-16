import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public abstract class Order extends ArrayList<Dish> {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private boolean isOnline;
    private boolean isRealised = false;
    private int numberOFOnlineOrders = 1;
    public Order(boolean isOnline) {
        id = incrementID();
        this.isOnline = isOnline;
    }

    public double calculatePrice(){
        return this.stream()
                .filter(Dish::isAvailable)
                .mapToDouble(Dish::getPrice)
                .sum();

    }

    public int getId() {
        return id;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public static int incrementID(){
        int id = count.incrementAndGet();
        return id;
    }

    public void deleteById(){
        Restaurant.currentOrders
                .removeIf(x -> x.getId() == this.getId());
    }

    public static void showOrders (ArrayList<Order> orders) {
        orders.forEach(System.out::println);
    }

    public static void showOrderIds (ArrayList<Order> orders) {
        orders.stream().map(Order::getId).forEach(System.out::println);
    }

    public void startMakingOrder()  {
        try {
            System.out.println("# Started making an order: " + getId());

            System.out.println(isOnline ? "# Online Order" : "# Stationary Order");
            this.stream()
                    .forEach(this::isAvailableIfNotThrowException);
            if(isOnline()) {
                startDelivery();
            }
            System.out.println("$ Final Price is: " + this.calculatePrice() + "\n# Finished making an order: " + getId() + "\n -------------------------------");
            Restaurant.oldOrders.add(this);

            deleteById();
        }catch(Exception e){}


    }

    private void startDelivery() {
            for (int i = 0; i < numberOFOnlineOrders; i++) {
                Supplier.setIsAvailable(false);
                SupplierThread spThr = new SupplierThread();
                spThr.start();
                Supplier.setIsAvailable(true);
        }

    }

    private void isAvailableIfNotThrowException(Dish x) {
        if (x.isAvailable())
        {
            x.startMakingDish();
    }
        else{
            x.skip();
            try {
                System.err.println("!!!Order with not available dish !!!\n !!!Infrom client!!!");
                throw new NotAvailableException("Dish: " + x.getName() + " is not available");
            } catch (NotAvailableException e) {
            }
        }
    }


    public static ArrayList<Order> initializeOrders(){
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

    static void startMakingOrders(ArrayList<Order> onlineOrders, ArrayList<Order> stationaryOrders, ArrayList<Waiter> waiters){
        if(Kitchen.isOpened()) {
            System.out.println("STARTED MAKING ORDERS \n");
            System.out.println(" --- ONLINE ORDERS --- ");
            onlineOrders.forEach(x ->{
                x.startMakingOrder();
                try {
                    Supplier.Supply(consoleClass.getSuppliers(), x );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println("\n\n --- STATIONARY ORDERS --- \n\n ");
            stationaryOrders.forEach(x ->{
                x.startMakingOrder();
                Waiter waiter = waiters.get((int)(Math.random() * waiters.size()));
                int index = waiters.indexOf(waiter);
                waiter.setNumberOfRealisedOrders(waiter.getNumberOfRealisedOrders()+1);
                waiter.giveTip();
                waiters.set(index, waiter);
            });
            System.out.println("FINISHED MAKING AN ORDERS");
        } else {
            System.out.println("Can't start making orders, Kitchen is closed");
        }
        waiters.forEach(x -> System.out.println(x.getTips()));
    }

    public static ArrayList<Order> getStationaryOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(Order::isOnline)
                .collect(Collectors.toList());
    }
    public static ArrayList<Order> getOnlineOrders(ArrayList<Order> orders) {
        return (ArrayList<Order>) orders.stream()
                .filter(x -> !x.isOnline())
                .collect(Collectors.toList());
    }

}
