package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;

@Repository
public interface ProjectRepository
        extends JpaRepository<Project, Long> {

    /*
     * 
     * @Query("delete from Book b where b.title=:title")
     * void deleteBooks(@Param("title") String title);
     */

}
