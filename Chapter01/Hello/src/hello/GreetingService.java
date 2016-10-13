package hello;

import javax.annotation.Named;
import javax.context.RequestScoped;

@Named("foo")
@RequestScoped
public class GreetingService {
    public String getSubject() {
        return "Paul";
    }
}