package model;

import javax.persistence.*;

@Entity
public class MotorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeName;

    public MotorType(String typeName) {
        this.typeName = typeName;
    }

    public MotorType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
