package cat.itacademy.s04.t02.n02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double quilsQuantity;

    public Fruit(){
    }

    public Fruit(String name, double quilsQuantity) {
        this.name = name;
        this.quilsQuantity = quilsQuantity;
    }

    public double getQuilsQuantity() {
        return quilsQuantity;
    }

    public void setQuilsQuantity(double quilsQuantity) {
        this.quilsQuantity = quilsQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
