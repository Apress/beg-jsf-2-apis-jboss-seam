package postage;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.inject.Current;

@Named("r")
@RequestScoped
public class Request {
    private int weight;
    private String patronCode;
    @Current
    private PostageService postageService;

    public Request() {
    }

    public Request(int weight, String patronCode) {
        this.weight = weight;
        this.patronCode = patronCode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPatronCode() {
        return patronCode;
    }

    public void setPatronCode(String patronCode) {
        this.patronCode = patronCode;
    }

    public int getPostage() {
        return postageService.getPostage(this);
    }

    public boolean isValid() {
        if (patronCode.equals("p1") && weight > 50) {
            return false;
        }
        return true;
    }

}
