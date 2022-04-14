import java.util.concurrent.atomic.AtomicInteger;

public class Dish {
    private final String name;
    private final int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private double price;
    private boolean isAvailable;
    private boolean isVegan;
    private boolean isSpicy;

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
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isPresent=" + isAvailable +
                ", isVegan=" + isVegan +
                ", isSpicy=" + isSpicy +
                ", id=" + id +
                '}';
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

}


