package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee"), inverseJoinColumns = @JoinColumn(name = "project"))
    Set<Project> projects = new HashSet<>();
    private String name;

    public Set<Project> getProjects() {
        return projects;
    }

    private String printProjects() {
        String str = "";
        for (Project project : projects) {
            str += project.getName() + " ";
        }
        return str;
    }

    @Transient
    private Integer age;

    private LocalDate dob;

    @Column(unique = true)
    private String email;

    public Employee() {

    }

    public Employee(
            Long id,
            String name, LocalDate dob,
            String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;

    }

    public Employee(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public String removeProject(Project p) {
        if (this.projects.contains(p)) {
            this.projects.remove(p);
            p.removeEmployee(this);
            return "removed";
        }
        throw new IllegalStateException();
    }

    public String assignProject(Project p) {
        if (!this.projects.contains(p)) {
            this.projects.add(p);
            p.addEmployee(this);
            return "added";
        }
        throw new IllegalStateException();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.email);
    }

    @Override
    public String toString() {
        return "Employe{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", dob='" + getDob() + "'" +
                ", email='" + getEmail() + "'" +
                ", projects: " + printProjects() +
                "}";
    }

}
