package demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {
    public Student() {
    }
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name ="name")
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "grade")
    private int grade;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student(int id, String name, String course, int grade) {

        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public Student(int id, String name, String course, int grade,Address address) {

        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
        this.address = address;
    }
}
