package com.example.demo.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        return args -> {
            Employee jopy = new Employee(
                    1L,
                    "Jopy",
                    LocalDate.of(1998, 1, 24),
                    "jopy.peamo@gmail.com");
            Employee sam = new Employee(
                    2L,
                    "Sam",
                    LocalDate.of(1998, 1, 24),
                    "sam.buldrum@gmail.com");

            Project p1 = new Project("App1");
            Project p2 = new Project("App2");

            employeeRepository.saveAll(List.of(jopy, sam));
            projectRepository.save(p2);
            projectRepository.save(p1);
            sam.addProject(p2);
            sam.addProject(p1);
            employeeRepository.save(sam);
            System.out.println(sam.toString());
            System.out.println(p2.toString());

        };
    }
}
