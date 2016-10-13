package wizard;

import javax.annotation.Named;
import javax.context.Conversation;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("step2")
@RequestScoped
public class Step2 {
    @Current
    private Conversation c;
    @Current
    private Ticket ticket;
    
    public String finish() {
        submit(ticket);
        c.end();
        return "finish";
    }

    private void submit(Ticket ticket) {
        System.out.println(ticket.getCustomerId());
        System.out.println(ticket.getProblemDesc());
    }
}
