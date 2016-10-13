package shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @Min(0)
    private double price;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
