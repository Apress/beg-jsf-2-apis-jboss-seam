package shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Named;
import javax.context.SessionScoped;

@Named("cart")
@SessionScoped
public class Cart implements Serializable {
    private List<String> productIds;

    public Cart() {
        productIds = new ArrayList<String>();
    }

    public void add(String pid) {
        productIds.add(pid);
    }

    public List<String> getProductIds() {
        return productIds;
    }
}
