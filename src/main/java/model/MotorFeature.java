package model;

import javax.persistence.*;

@Entity
@Table(name = "motorfeature")
public class MotorFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cc;
    private String hp;
    private String specify;
    private String color;

    public MotorFeature(String cc, String hp, String option, String color) {
        this.cc = cc;
        this.hp = hp;
        this.specify = option;
        this.color = color;
    }

    public MotorFeature() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getOption() {
        return specify;
    }

    public void setOption(String option) {
        this.specify = option;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
