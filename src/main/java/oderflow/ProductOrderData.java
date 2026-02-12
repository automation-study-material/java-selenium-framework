package oderflow;
import java.util.List;

public class ProductOrderData {

    private List<String> productsToOrder;
    private CustomerDetails customerDetails;

    // ===== Getter/Setter =====

    public List<String> getProductsToOrder() {
        return productsToOrder;
    }

    public void setProductsToOrder(List<String> productsToOrder) {
        this.productsToOrder = productsToOrder;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "ProductOrderData{" +
                "productsToOrder=" + productsToOrder +
                ", customerDetails=" + customerDetails +
                '}';
    }
}
