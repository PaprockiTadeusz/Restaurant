package Kitchen;

import Exceptions.NotAvailableException;

import java.util.concurrent.atomic.AtomicInteger;

public class Dish {
    private final String name;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private double price;
    private boolean isAvailable;
    private boolean isVegan;
    private boolean isSpicy;
    private boolean isFinished;

    public Dish(String name, double price, boolean isPresent, boolean isVegan, boolean isSpicy) {
        this.name = name;
        this.price = price;
        this.isAvailable = isPresent;
        this.isVegan = isVegan;
        this.isSpicy = isSpicy;
        id = count.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Kitchen.Dish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", isVegan=" + isVegan +
                ", isSpicy=" + isSpicy +
                ", isFinished=" + isFinished +
                '}';
    }
    public String toStringInMenu() {
        return  (this.isAvailable() ? "☑ " : "✗ ") + this.getName() + " | Price: " + this.getPrice() + " | Vegan: " + (this.isVegan() ? "☑" : "✗" ) + " | Spicy: " + (this.isSpicy() ? "☑" : "✗" );

    }
    public String onlyVegan(){
        return this.isVegan ? toStringInMenu() : "";
    }
    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private boolean checkIsAvailable() throws NotAvailableException {
        boolean a = false;
            if(isAvailable){
                a = true;
            }
            else{
                throw new NotAvailableException("This position currently is not Available :( ");
            }
            return a;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public int getId() {
        return id;
    }

    public void startMakingDish()  {
            try {
                Thread dishThread = new Thread();
                dishThread.start();
                dishThread.sleep((long) (1000));
                isFinished = true;
                System.out.println("* Kitchen.Dish is finished: " + getName() + " ✔");
            } catch (InterruptedException e) {}
        }
    public void skip(){
        isFinished = true;
    }
    }






