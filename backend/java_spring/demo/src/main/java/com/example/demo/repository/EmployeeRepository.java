package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // @Query("SELECT e FROM Employee e WHERE e.id = 1")
    Optional<Employee> findEmployeeByEmail(String email);

    Optional<Employee> findEmployeeById(Long id);

    /*
     * 
     * @Query("delete from Book b where b.title=:title")
     * void deleteBooks(@Param("title") String title);
     */

}
