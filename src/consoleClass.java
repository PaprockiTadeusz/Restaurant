import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class consoleClass {

    static ArrayList<Order> oldOrders = new ArrayList<>();
    static ArrayList<Order> currentOrders = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Order> onlineOrders = new ArrayList<>();
    private static ArrayList<Order> stationaryOrders = new ArrayList<>();

    private static ArrayList<Employee> employees = new ArrayList<>();

    static Menu menu = Menu.initializeMenu();

    static ArrayList<Cooker> cookers = new ArrayList<>();
    static ArrayList<Supplier> suppliers = new ArrayList<>();
    static ArrayList<Waiter> waiters = new ArrayList<>();


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


    private static Kitchen kitchen = new Kitchen(employees);

    public static void  mainMenu(){
        int option = 0;
        Scanner mainMenuScanner = new Scanner(System.in);
        System.out.println("\nWhat you want to do? \n" +
                "\nKitchen and Menu Options \n###################################### \n" +
                "1. Open Kitchen \n" +
                "2. Stop Kitchen  \n" +
                "3. Start Making Orders  \n" +
                "4. Show daily income \n" +
                "5. Show Current Orders  \n" +
                "6. Show Old Orders  \n" +
                "7. Show All Employees  \n" +
                "8. Show One Employees  \n" +
                "\nAdding / Deleting Options \n###################################### \n" +
                "9. Add new dish to Menu \n" +
                "10. Delete dish from menu \n" +
                "11. Employ new Employee \n" +
                "12. Fire Employee \n" +
                "\nClient Options \n###################################### \n" +
                "13. Show Menu \n" +
                "14. Show Menu for Vegans \n" +
                "15. Show Spicy Meals \n" +
                "16. Make Online Order \n" +
                "17. Make Stationary Order \n" +
                "18. Read Menu from a file \n" +
                "19. Save Menu to a file \n");

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
            case 9 -> addToMenu();
            case 10 -> removeFromMenu();
            case 11 -> addEmployee();
            case 12 -> fireEmployee();
            case 13 -> Menu.showMenu(menu);
            case 14 -> Menu.onlyVegan(menu);
            case 15 -> Menu.onlySpicy(menu);
            case 16 -> makeOnlineOrder();
            case 17 -> makeStationaryOrder();
            case 18 -> readFromAFile();
            case 19 -> saveToAFile();
        }
        }catch(Exception e){
            System.err.println("SOMETHING WENT WRONG, TRY AGAIN");
            mainMenu();
            }
        }


    private static void addEmployee(){

        Employee emp = null;
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
        System.out.println("Which type of employee you want to employ? \n1.Cooker\n2.Waiter\n3.Supplier");
        int choosenOption = addingEmployeeScanner.nextInt();
        switch(choosenOption){
            case 1 -> emp = new Cooker(empName, empSurname, age, telephoneNumber, LocalDate.now());
            case 2 -> emp = new Waiter(empName, empSurname, age, telephoneNumber, LocalDate.now());
            case 3 -> emp = new Supplier(empName, empSurname, age, telephoneNumber, LocalDate.now());
            default -> { System.out.println("Bad type. You have to add Employee again"); addEmployee();}
        }
        System.out.println("!Added a new Employee! \n");
        employees.add(emp);

//        mainMenu();

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
      System.out.println("Added new Online Order");


  }
    private static void makeStationaryOrder() {
      StationaryOrder order = new StationaryOrder(false);
        Scanner numberScanner = new Scanner(System.in);
        makeingOrder(numberScanner, order);
        orders.add(order);
        currentOrders.add(order);
        System.out.println("Added new Stationary Order");

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
//        ArrayList<Employee> = getSuppliers();
        Order.startMakingOrders(stationaryOrders, onlineOrders);

    }

    private static void readFromAFile() throws IOException {
        Path path = Path.of("D:\\Spring\\Restaurantt\\src\\menu.txt");

        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String text= sb.toString();
        } catch(Exception e){

        }
    }
    private static void saveToAFile() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedMenu.txt"));
            StringBuilder builder = new StringBuilder();
            menu.forEach(x -> builder.append(x.toString()));
            writer.write(String.valueOf(builder));
            writer.write("hello");
            writer.close();
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


    }

