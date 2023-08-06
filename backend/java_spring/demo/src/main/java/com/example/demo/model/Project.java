package com.example.demo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "projects")
    Set<Employee> employees = new HashSet<>();

    public Project() {

    }

    public Project(
            Long id,
            String name) {
        this.id = id;
        this.name = name;

    }

    public void addEmployee(Employee e) {
        if (!this.employees.contains(e)) {
            this.employees.add(e);
            e.addProject(this);
        }
    }

    public Project(String name) {
        this.name = name;

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", employees='" + getEmployees() + "'" +
                "}";
    }

}
