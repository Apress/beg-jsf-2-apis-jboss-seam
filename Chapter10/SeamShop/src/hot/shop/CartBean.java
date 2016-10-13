package shop;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;


@Stateful
@Name("cart")
@Scope(ScopeType.SESSION)
public class CartBean implements Cart {
    private List<Long> pids;
    @In(required=false)
    private ProductHome productHome;
    
    public CartBean() {
        pids = new ArrayList<Long>();
    }
    @Override
    public void add() {
        Long pid = productHome.getProductId();
        pids.add(pid);
    }
    @Override
    public List<Long> getPids() {
        return pids;
    }
    @Remove
    public void destroy() {
        
    }
}