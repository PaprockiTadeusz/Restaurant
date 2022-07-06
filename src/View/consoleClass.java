package View;

import Employees.Cooker;
import Employees.Employee;
import Employees.Supplier;
import Employees.Waiter;
import Kitchen.Dish;
import Kitchen.Kitchen;
import Kitchen.Menu;
import Orders.OnlineOrder;
import Orders.Order;
import Orders.StationaryOrder;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class consoleClass {

    private static ArrayList<Order> oldOrders = new ArrayList<>();
    private static ArrayList<Order> currentOrders = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Order> onlineOrders = new ArrayList<>();
    private static ArrayList<Order> stationaryOrders = new ArrayList<>();

    private static ArrayList<Employee> employees = new ArrayList<>();

    private static Menu menu = Menu.initializeMenu();

    private static ArrayList<Cooker> cookers = new ArrayList<>();
    private static ArrayList<Supplier> suppliers = new ArrayList<>();
    private static ArrayList<Waiter> waiters = new ArrayList<>();


    public consoleClass(ArrayList<Order> oldOrders, ArrayList<Order> currentOrders, ArrayList<Order> orders, ArrayList<Order> onlineOrders, ArrayList<Order> stationaryOrders, ArrayList<Employee> employees, ArrayList<Cooker> cookers, ArrayList<Waiter> waiters, ArrayList<Supplier> suppliers) {
        this.oldOrders = oldOrders;
        this.currentOrders = currentOrders;
        this.orders = orders;
        this.onlineOrders = onlineOrders;
        this.stationaryOrders = stationaryOrders;
        this.employees = employees;
        this.cookers = cookers;
        this.suppliers = suppliers;
        this.waiters = waiters;
    }


    private static Kitchen kitchen = new Kitchen(cookers);

    public static void  mainMenu(){
        int option = 0;
        Scanner mainMenuScanner = new Scanner(System.in);
        System.out.println("\nWhat you want to do? \n" +
                "\nKitchen and Menu Options \n###################################### \n" +
                "1. Open Kitchen.Kitchen \n" +
                "2. Stop Kitchen.Kitchen  \n" +
                "3. Start Making Orders  \n" +
                "4. Show daily income \n" +
                "5. Show Current Orders  \n" +
                "6. Show Old Orders  \n" +
                "7. Show All Employees  \n" +
                "8. Show One Employees  \n" +
                "9. Get Tips  \n" +
                "10. Show realised orders  \n" +
                "\nAdding / Deleting Options \n###################################### \n" +
                "11. Add new dish to Kitchen.Menu \n" +
                "12. Delete dish from menu \n" +
                "13. Employ new Employees.Employee \n" +
                "14. Fire Employees.Employee \n" +
                "\nClient Options \n###################################### \n" +
                "15. Show Kitchen.Menu \n" +
                "16. Show Kitchen.Menu for Vegans \n" +
                "17. Show Spicy Meals \n" +
                "18. Make Online Orders.Order \n" +
                "19. Make Stationary Orders.Order \n" +
                "20. Read Kitchen.Menu from a file \n" +
                "21. Save Kitchen.Menu to a file \n");

        int chosenOption = mainMenuScanner.nextInt();
        mainMenuSwitch(chosenOption);
        mainMenu();

    }

    private static void mainMenuSwitch(int chosenOption){
        try{
        switch(chosenOption) {
            case 1 -> kitchen.startKitchen();
            case 2 -> kitchen.stopKitchen();
            case 3 -> deliverOrders();
            case 4 -> System.out.println("Today we have earned: " + Kitchen.getDailyRevenue(oldOrders));
            case 5 -> Order.showOrders(currentOrders);
            case 6 -> Order.showOrders(oldOrders);
            case 7 -> employees.forEach(System.out::println);
            case 8 -> getEmployeeById();
            case 9 -> waiters.stream().forEach(x -> System.out.println(x.getName() + ": " + x.getTips()));
            case 10 -> waiters.stream().forEach(x -> System.out.println(x.getName() + ": " + x.getNumberOfRealisedOrders()));
            case 11 -> addToMenu();
            case 12 -> removeFromMenu();
            case 13 -> addEmployee();
            case 14 -> fireEmployee();
            case 15 -> Menu.showMenu(menu);
            case 16 -> Menu.onlyVegan(menu);
            case 17 -> Menu.onlySpicy(menu);
            case 18 -> makeOnlineOrder();
            case 19 -> makeStationaryOrder();
            case 20 -> readFromAFile();
            case 21 -> saveToAFile();
        }
        }catch(Exception e){
            System.err.println("SOMETHING WENT WRONG, TRY AGAIN");
            mainMenu();
            }
        }


    private static void addEmployee(){

        Cooker cooker = null;
        Waiter waiter = null;
        Supplier supplier = null;
        String empName = "";
        String empSurname = "";
        int age = 0;
        int telephoneNumber = 0;
        LocalDate dateOfEmployment;

        Scanner addingEmployeeScanner = new Scanner(System.in);
        Scanner nameOfEmpScanner = new Scanner(System.in);
        Scanner surnameOfEmpScanner = new Scanner(System.in);
        Scanner ageOfEmp = new Scanner(System.in);
        Scanner phoneNumberScanner = new Scanner(System.in);


        System.out.println("Type name: ");
        empName = nameOfEmpScanner.nextLine();
        System.out.println("Type surname: ");
        empSurname = surnameOfEmpScanner.nextLine();
        System.out.println("Type age: ");
        age = surnameOfEmpScanner.nextInt();
        System.out.println("Type phone number: ");
        telephoneNumber = phoneNumberScanner.nextInt();
        System.out.println("Which type of employee you want to employ? \n1.Employees.Cooker\n2.Employees.Waiter\n3.Employees.Supplier");
        int choosenOption = addingEmployeeScanner.nextInt();
        switch(choosenOption){
            case 1 : cooker =  new Cooker(empName, empSurname, age, telephoneNumber, LocalDate.now()); cookers.add(cooker);employees.add(cooker); break;
            case 2 : waiter = new Waiter(empName, empSurname, age, telephoneNumber, LocalDate.now()); waiters.add(waiter);employees.add(waiter); break;
            case 3 : supplier = new Supplier(empName, empSurname, age, telephoneNumber, LocalDate.now()); suppliers.add(supplier); employees.add(supplier);break;
            default :  System.out.println("Bad type. You have to add Employees.Employee again"); addEmployee();
        }
        System.out.println("!Added a new Employees.Employee! \n");


    }

    private static void fireEmployee(){
        Scanner empId = new Scanner(System.in);

        employees.stream().forEach(System.out::println);
        System.out.println("Which employee you want to fire?");

        int id = empId.nextInt() - 1;
        if(employees.size() == 0){
            System.out.println("Currently we don't hire any Employees");
        }else {
            employees.remove(id);
        }

    }

  private static void makeOnlineOrder(){
      Scanner adressScanner = new Scanner(System.in);
      Scanner numberScanner = new Scanner(System.in);

      System.out.println("Write adress: ");
      String adress = adressScanner.nextLine();
      OnlineOrder order = new OnlineOrder(adress, true);
      makeingOrder(numberScanner, order);
      orders.add(order);
      currentOrders.add(order);
      System.out.println("Added new Online Orders.Order");


  }
    private static void makeStationaryOrder() {
      StationaryOrder order = new StationaryOrder(false);
        Scanner numberScanner = new Scanner(System.in);
        makeingOrder(numberScanner, order);
        orders.add(order);
        currentOrders.add(order);
        System.out.println("Added new Stationary Orders.Order");

  }
    private static void makeingOrder(Scanner numberScanner, Order order) {
        menu.stream().forEach(System.out::println);
        System.out.println("\n# Type dish number you want to add \n# If you want to stop type 0");
        int number ;
        do {
            number = numberScanner.nextInt();
            if(number != 0){
                order.add(menu.get(number - 1));
            }
        }
         while (number != 0);

    }

    private static void getEmployeeById(){
        System.out.println("Enter employee number. Currently we hire " + employees.size() + " employees");
        Scanner numberScanner = new Scanner(System.in);
        int number = numberScanner.nextInt() - 1;
        employees.stream()
                .filter(x -> x.getId() == number)
                .forEach(System.out::println);
        mainMenu();

    }


    private static void addToMenu(){
        Scanner nameScanner = new Scanner(System.in);
        Scanner priceScanner = new Scanner(System.in);
        Scanner isAvailableScanner = new Scanner(System.in);
        Scanner isVeganScanner = new Scanner(System.in);
        Scanner isSpicyScanner = new Scanner(System.in);

        System.out.println("Write dish name: ");
        String name = nameScanner.nextLine();
        System.out.println("Write dish price");
        double price = priceScanner.nextInt();
        System.out.println("Is available? \nYes - true No - false");
        boolean isAvailable = isAvailableScanner.nextBoolean();
        System.out.println("Is vegan? \nYes - true No - false");
        boolean isVegan = isVeganScanner.nextBoolean();
        System.out.println("Is spicy? \nYes - true No - false");
        boolean isSpicy = isSpicyScanner.nextBoolean();
        Dish newDish = new Dish(name, price, isAvailable, isVegan, isSpicy);
        menu.add(newDish);
        System.out.println("Added " + name + " to menu");
    }

    private static void removeFromMenu(){
        Scanner numberScanner = new Scanner(System.in);
        Menu.showMenu(menu);
        System.out.println("Which dish you want to delete?");
        int num = numberScanner.nextInt();
        menu.remove(num - 1);

    }
    private static void deliverOrders(){
        Order.startMakingOrders(stationaryOrders, onlineOrders, waiters);

    }
    private static void readFromAFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Spring\\FileReader\\src\\menu.txt"));
        StringBuilder sb = new StringBuilder();
        int ch;
        int number = 0;


        String name = "";
        double price = 0;
        boolean isPresent = false;
        boolean isVegan = false;
        boolean isSpicy = false;

        Menu newMenu = new Menu();
        try {

            while ((ch = br.read()) >= 0) {

                if (ch == ',' && number == 0) {
                    name = sb.toString();
                    sb.setLength(0);
                    number++;
                } else if (ch == ',' && number == 1) {
                    price = Double.parseDouble(sb.toString());
                    sb.setLength(0);
                    number++;
                } else if (ch == ',' && number == 2) {
                    isPresent = Boolean.parseBoolean(sb.toString());
                    sb.setLength(0);
                    number++;
                } else if (ch == ',' && number == 3) {
                    isVegan = Boolean.parseBoolean(sb.toString());
                    sb.setLength(0);
                    number++;
                } else if (ch == ';' && number == 4) {
                    isSpicy = Boolean.parseBoolean(sb.toString());
                    sb.setLength(0);

                    Dish dish = new Dish(name, price, isPresent, isVegan, isSpicy);
                    newMenu.add(dish);

                    number=0;
                }
                else {
                    sb.append((char) ch);
                }
            }
            menu = newMenu;

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void saveToAFile() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedMenu.txt"));
            StringBuilder builder = new StringBuilder();

            for(Dish d : menu ) {
                writer.write(d.getName() + ",");
                writer.write(d.getPrice() + ",");
                writer.write(d.isAvailable() + ",");
                writer.write(d.isSpicy() + ",");
                writer.write(d.isVegan() + ";\n");
            }
            writer.close();

//            menu.forEach(x -> builder.append(x.toString()));
//            writer.write(String.valueOf(builder));
//            writer.write("hello");
//            writer.close();
        }catch(Exception e){

        }
    }

    public static ArrayList<Order> getOldOrders() {
        return oldOrders;
    }
    public static ArrayList<Order> getCurrentOrders() {
        return currentOrders;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }
}

