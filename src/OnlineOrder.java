import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class OnlineOrder extends Order{

    private LocalDateTime dateOfOreder;

    private String adress;

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
}
