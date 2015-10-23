package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Car {

    
    @Id
    @GeneratedValue
    private Long id;
    
    private int yearMade;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registered;
    private String make;
    private String model;
    private String description;
    private double price;

    public Car() {
    }

    public Car(int yearMade, Date registered, String make, String model, String description, double price) {
        this.yearMade = yearMade;
        this.registered = registered;
        this.make = make;
        this.model = model;
        this.description = description;
        this.price = price;
    }
    
    
    public int getYear() {
        return yearMade;
    }

    public void setYear(int year) {
        this.yearMade = year;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
