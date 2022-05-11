public class SupplierThread extends Thread {
    @Override
    public void run(){

        System.out.println("✈ Supplier during deliver");
        try{
            sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("✈ Supplier in restaurant");
    }
}
