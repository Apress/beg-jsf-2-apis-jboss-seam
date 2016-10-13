package shop;

import java.io.Serializable;

import javax.annotation.Named;
import javax.context.SessionScoped;

@Named("uh")
@SessionScoped
public class UserHolder implements Serializable {
    private User currentUser;
    private String originalViewId;
    
    public String getOriginalViewId() {
        return originalViewId;
    }
    public void setOriginalViewId(String originalViewId) {
        this.originalViewId = originalViewId;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}
