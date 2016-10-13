package shop;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("ph")
@RequestScoped
public class ProductHolder {
    private Product currentProduct;
    @Current
    private Cart cart;
    @Current
    private Catalog catalog;

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public String getProductId() {
        return currentProduct != null ? currentProduct.getId() : null;
    }

    public void setProductId(String pid) {
        currentProduct = catalog.getProduct(pid);
    }

    public String addToCart() {
        System.out.println("Adding " + currentProduct.getId());
        cart.add(currentProduct.getId());
        return "added";
    }
}
