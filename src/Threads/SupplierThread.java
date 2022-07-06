package Threads;

public class SupplierThread extends Thread {

    public void start(long time){

        System.out.println("✈ Supplier during deliver");
        try{
            sleep(time);
        } catch (InterruptedException e) {
        }
        System.out.println("✈ Supplier in restaurant");
    }
}
