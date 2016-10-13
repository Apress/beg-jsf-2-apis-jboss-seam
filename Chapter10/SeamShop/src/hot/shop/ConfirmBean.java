package shop;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.Credentials;

@Stateless
@Name("confirm")
@Scope(ScopeType.EVENT)
public class ConfirmBean implements Confirm {
    @In
    private Credentials credentials;
    @In
    private Cart cart;
    @In
    private EntityManager entityManager;

    @Override
    public String getCreditCardNo() {
        if (credentials.getUsername().equals("u1")) {
            return "1234";
        }
        return "unknown";
    }

    @Override
    public double getTotal() {
        Query q = entityManager
                .createQuery("select p from Product p where p.id=:id");
        double total = 0;
        for (Long pid : cart.getPids()) {
            q.setParameter("id", pid);
            Product p = (Product) q.getSingleResult();
            total += p.getPrice();
        }
        return total;

    }

    @Remove
    public void destroy() {

    }

}
