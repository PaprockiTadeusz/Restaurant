import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class OnlineOrder extends Order{

    private LocalDateTime dateOfOreder;

    private String adress;
    private boolean isDelivered = false;

    public OnlineOrder(String adress, boolean isOnline) {
        super(isOnline);
        this.adress = adress;
    }



    public LocalDateTime getDateOfOreder() {
        return dateOfOreder;
    }

    public String getAdress() {
        return adress;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
