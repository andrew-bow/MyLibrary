package org.library.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "dob")
    private int dob;

    public Person(){}

    public Person(String fullName, int dob) {
        this.fullName = fullName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", full_name='" + fullName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
