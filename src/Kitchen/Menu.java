package Kitchen;

import java.util.ArrayList;

public class Menu extends ArrayList<Dish> {

    public static Menu initializeMenu() {

        Menu menu = new Menu();

        Dish kfc = new Dish("Korean Fried Chickien", 29, true, false, true);
        Dish mildFriedChicken = new Dish("Mild Fried Chicken", 29, true, false, false);
        Dish spicyPork = new Dish("Spicy Pork", 29, false, false, true);
        Dish teriyakiDuck = new Dish("Teriyaki Duck", 35, true, false, false);
        Dish koreanTofu = new Dish("Korean Tofu", 29, true, true, false);
        Dish braisedBeef = new Dish("Braised Beef", 33, true, false, false);

        Dish smallWater = new Dish("Small Water", 4, true, true, false);
        Dish bigWater = new Dish("Big Water", 6, true, true, false);
        Dish redWine = new Dish("Red Wine", 15, true, true, false);
        Dish whiteWine = new Dish("White Wine", 14, true, true, false);
        Dish cola = new Dish("Cola", 5, true, true, false);

        menu.add(kfc);
        menu.add(mildFriedChicken);
        menu.add(spicyPork);
        menu.add(teriyakiDuck);
        menu.add(koreanTofu);
        menu.add(braisedBeef);

        menu.add(smallWater);
        menu.add(bigWater);
        menu.add(redWine);
        menu.add(whiteWine);
        menu.add(cola);
        return menu;

    }


    public static void showMenu(Menu menu){
        menu.forEach(x -> System.out.println(x.toStringInMenu()));
    }
    public static void onlyVegan(Menu menu){
        menu.stream().filter(x -> x.isVegan()).forEach(x -> System.out.println(x.toStringInMenu()));
    }
    public static void onlySpicy(Menu menu){
        menu.stream().filter(x -> x.isSpicy()).forEach(x -> System.out.println(x.toStringInMenu()));
    }


}
