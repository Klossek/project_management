package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @CrossOrigin
    @PostMapping(path = "/{id}/assignProject/{projectId}")
    public String assignProject(@PathVariable("id") Long employeeId, @PathVariable("projectId") Long projectId) {
        return this.employeeService.assignProject(employeeId, projectId);
    }

    @CrossOrigin
    @PostMapping(path = "/{id}/removeProject/{projectId}")
    public String removeProject(@PathVariable("id") Long employeeId, @PathVariable("projectId") Long projectId) {
        return this.employeeService.removeProject(employeeId, projectId);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {

        this.employeeService.deleteEmployee(employeeId);
    }

    @DeleteMapping(path = "email/{employeeEmail}")
    public void deleteEmployeeByMail(@PathVariable("employeeEmail") String employeeEmail) {
        this.employeeService.deleteEmployeeByMail(employeeEmail);
    }

}
