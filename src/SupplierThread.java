public class SupplierThread extends Thread {

    public void run(long time){

        System.out.println("✈ Supplier during deliver");
        try{
            sleep(time);
        } catch (InterruptedException e) {
        }
        System.out.println("✈ Supplier in restaurant");
    }
}
