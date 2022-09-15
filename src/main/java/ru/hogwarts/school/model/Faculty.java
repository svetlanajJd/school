package ru.hogwarts.school.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    @OneToMany(mappedBy = "faculty")
    private List<Student> students;



    public Faculty(Long id, String name, String color,List<Student> students) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.students=students;
    }

    public List<Student> getStudents() {
        return students;
    }
    public Faculty() {
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
