package wizard;

import java.io.Serializable;

import javax.annotation.Named;
import javax.context.ConversationScoped;

@Named("ticket")
@ConversationScoped
public class Ticket implements Serializable {
    private String customerId;
    private String problemDesc;
    
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getProblemDesc() {
        return problemDesc;
    }
    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }
     
}
