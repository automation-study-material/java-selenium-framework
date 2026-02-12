package oderflow;
import java.util.List;
public class CustomerDetails {

    private String firstName;
    private String cardNo;

    // ===== Getter/Setter =====

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "firstName='" + firstName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}