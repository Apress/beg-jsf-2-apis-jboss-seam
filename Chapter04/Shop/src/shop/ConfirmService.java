package shop;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("confirmService")
@RequestScoped
public class ConfirmService {
    @Current
    private Cart cart;
    @Current
    private Catalog catalog;
    @Current
    private UserHolder uh;

    public double getTotal() {
        double total = 0;
        for (String pid : cart.getProductIds()) {
            total += catalog.getProduct(pid).getPrice();
        }
        return total;
    }
    public String getCreditCardNo() {
        return uh.getCurrentUser().getCreditCardNo();
    }
}
