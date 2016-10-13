package shop;

import shop.*;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("productHome")
public class ProductHome extends EntityHome<Product> {

    public void setProductId(Long id) {
        setId(id);
    }

    public Long getProductId() {
        return (Long) getId();
    }

    @Override
    protected Product createInstance() {
        Product product = new Product();
        return product;
    }

    public void wire() {
        getInstance();
    }

    public boolean isWired() {
        return true;
    }

    public Product getDefinedInstance() {
        return isIdDefined() ? getInstance() : null;
    }

}
