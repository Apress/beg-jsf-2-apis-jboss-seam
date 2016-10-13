package custom;

import javax.annotation.Named;
import javax.context.RequestScoped;

@Named("currentProduct")
@RequestScoped
public class Product {
    private String id;
    private String name;

    public Product() {
        this("p1", "pen");
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String onUpdated() {
        System.out.println(id + ": " + name);
        return "updated";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
