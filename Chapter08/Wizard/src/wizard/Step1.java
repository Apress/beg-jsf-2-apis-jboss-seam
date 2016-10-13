package wizard;

import javax.annotation.Named;
import javax.context.Conversation;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("step1")
@RequestScoped
public class Step1 {
    @Current
    private Conversation c;
    
    public String next() {
        c.begin();
        return "next";
    }
}
