package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "height")
    private double height; //рост
    @Column(name = "weight")
    private int weight; //вес

    public User() {}

    public User(String name, String lastName, double height, int weight) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDiagnosis() {
        double index = weight/(height * height);
        String diagnosis = "not correct biometric data";
        if (index>40.0) {
            diagnosis = "grade III obesity";
        } else if (index>35.0 && index<=40.0) {
            diagnosis = "grade II obesity";
        } else if (index>30.0 && index<=35.0) {
            diagnosis = "grade I obesity";
        } else if (index>25.0 && index<=30.0) {
            diagnosis = "excess body weight";
        } else if (index>18.5 && index<=25.0) {
            diagnosis = "the norm of body weight";
        } else if (index>16.0 && index<=18.5) {
            diagnosis = "insufficient body weight";
        } else if (index>0 && index<=16.0) {
            diagnosis = "severe body weight deficiency";
        }
        return diagnosis;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lastName + ", рост-" + height + "м. вес-" + weight + "кг. ";
    }
}
