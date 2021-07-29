package model;

import javax.persistence.*;

@Entity
@Table(name = "motor")
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private MotorType motorType;
    private String pName;
    private double price;
    @OneToOne
    private MotorFeature motorFeature;

    private int onStock;

    public Motor(MotorType motorType, String pName, double price, int onStock) {
        this.motorType = motorType;
        this.pName = pName;
        this.price = price;
        this.onStock = onStock;
    }

    public Motor() {
    }

    public MotorFeature getMotorFeature() {
        return motorFeature;
    }

    public void setMotorFeature(MotorFeature motorFeature) {
        this.motorFeature = motorFeature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MotorType getMotorType() {
        return motorType;
    }

    public void setMotorType(MotorType motorType) {
        this.motorType = motorType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int onStock) {
        this.onStock = onStock;
    }
}
