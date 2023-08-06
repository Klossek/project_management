package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeService(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Employee> getEmployees() {
        // return String.format("Hello %s!", name);
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee) {
        Optional<Employee> emOptional = this.employeeRepository.findEmployeeByEmail(employee.getEmail());

        if (emOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        System.out.println(employee);
        employeeRepository.save(employee);
    }

    public void assignProject(Long employeeId, Long projectId) {
        Optional<Employee> emOptional = employeeRepository.findEmployeeById(employeeId);
        Optional<Project> pOptional = projectRepository.findById(projectId);
        try {
            Employee employee = emOptional.get();
            Project project = pOptional.get();
            employee.addProject(project);
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        boolean exists = employeeRepository.existsById(employee.getId());
        if (!exists) {
            throw new IllegalStateException("Employee with id " + employee.getId() + "  does not exist");
        }
        employeeRepository.save(employee);

    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + employeeId + "  does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }

    public void deleteEmployeeByMail(String employeeEmail) {
        Optional<Employee> emOptional = employeeRepository.findEmployeeByEmail(employeeEmail);
        try {
            Employee employee = emOptional.get();
            employeeRepository.deleteById(employee.getId());
        } catch (Exception e) {
            throw new IllegalStateException("Employee with email: " + employeeEmail + "  does not exist");
        }

    }

}
