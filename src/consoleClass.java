import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class consoleClass {

    static ArrayList<Order> oldOrders = new ArrayList<>();
    static ArrayList<Order> currentOrders = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Order> onlineOrders = new ArrayList<>();
    static ArrayList<Order> stationaryOrders = new ArrayList<>();

    static ArrayList<Employee> employees = new ArrayList<>();

    static Menu menu = Menu.initializeMenu();


    public consoleClass(ArrayList<Order> oldOrders, ArrayList<Order> currentOrders, ArrayList<Order> orders, ArrayList<Order> onlineOrders, ArrayList<Order> stationaryOrders, ArrayList<Employee> employees) {
        this.oldOrders = oldOrders;
        this.currentOrders = currentOrders;
        this.orders = orders;
        this.onlineOrders = onlineOrders;
        this.stationaryOrders = stationaryOrders;
        this.employees = employees;
    }
    private static Kitchen kitchen = new Kitchen(employees);

    public static void  mainMenu(){
        int option = 0;
        Scanner mainMenuScanner = new Scanner(System.in);
        System.out.println("What you want to do? \n" +
                "\nKitchen and Menu Options \n###################################### \n" +
                "1. Open Kitchen \n" +
                "2. Stop Kitchen  \n" +
                "3. Start Making Orders  \n" +
                "4. Stop Making Orders \n" +
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
                "17. Make Stationary Order \n"

        );
        int chosenOption = mainMenuScanner.nextInt();
        mainMenuSwitch(chosenOption);

    }

    public static void mainMenuSwitch(int chosenOption){
        switch(chosenOption){
            case 1 -> kitchen.startKitchen();
            case 2 -> kitchen.stopKitchen();
            case 3 -> Order.startMakingOrders(stationaryOrders, onlineOrders);
//            case 4 -> Order.stop // !!!
            case 5 -> { mainMenu();Order.showOrders(currentOrders);}
            case 6 -> { mainMenu();Order.showOrders(oldOrders);}
            case 7 -> { mainMenu();employees.forEach(System.out::println);}
//            case 8 ->  // !!!
//            case 9 -> addEmployee();
//            case 10 -> Menu.remove()
            case 11 -> addEmployee();
            case 12 -> fireEmployee();
            case 13 -> Menu.showMenu(menu);
            case 14 -> Menu.onlyVegan(menu);
            case 15 -> Menu.onlySpicy(menu);
            case 16 -> makeOnlineOrder();
            case 17 -> makeStationaryOrder();
        }
    }

    public static void addEmployee(){

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
            case 2 -> {emp = new Waiter(empName, empSurname, age, telephoneNumber, LocalDate.now());}
            case 3 -> emp = new Supplier(empName, empSurname, age, telephoneNumber, LocalDate.now());
            default -> { System.out.println("Bad type. You have to add Employee again"); addEmployee();}
        }
        System.out.println("!Added a new Employee! \n");
        employees.add(emp);

        mainMenu();

    }

    public static void fireEmployee(){
        Scanner empId = new Scanner(System.in);

        employees.stream().forEach(System.out::println);
        System.out.println("Which employee you want to fire?");

        int id = empId.nextInt();
        if(employees.size() == 0){
            System.out.println("Currently we don't hire any Employees");
        }else {
            employees.remove(id);
        }

        mainMenu();

    }

    public static void makeNewOrder(){

        Scanner orderType = new Scanner(System.in);

        System.out.println("Which type of Order do you want?");
        int orderTypeNumber = orderType.nextInt();
//        switch (orderTypeNumber){
//            case 1 -> ;
//        }

    }

  public static void makeOnlineOrder(){
      Scanner adressScanner = new Scanner(System.in);
      Scanner numberScanner = new Scanner(System.in);

      System.out.println("Write adress: ");
      String adress = adressScanner.nextLine();
      OnlineOrder order = new OnlineOrder(adress, true);
      makeingOrder(numberScanner, order);
      System.out.println("Added new Online Order");

      mainMenu();

  }
    public static void makeStationaryOrder() {
      StationaryOrder order = new StationaryOrder(false);
        Scanner numberScanner = new Scanner(System.in);
        makeingOrder(numberScanner, order);
        System.out.println("Added new Stationary Order");

        mainMenu();
  }
    private static void makeingOrder(Scanner numberScanner, Order order) {
        menu.stream().forEach(System.out::println);
        System.out.println("\n# Type dish number you want to add \n# If you want to stop type 0");
        int number = -1;
         while (number != 0){
             number = numberScanner.nextInt();
             order.add(menu.get(number));
         }
        orders.add(order);
    }

    private static void getEmployeeById(){
        Scanner numberScanner = new Scanner(System.in);
        int number = numberScanner.nextInt();
        mainMenu();
        employees.stream().filter(x -> x.getId() == number).forEach(System.out::println);

        mainMenu();

    }

}
