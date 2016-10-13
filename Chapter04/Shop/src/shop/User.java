package shop;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String creditCardNo;

    public User(String username, String password, String creditCardNo) {
        this.username = username;
        this.password = password;
        this.creditCardNo = creditCardNo;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

}
