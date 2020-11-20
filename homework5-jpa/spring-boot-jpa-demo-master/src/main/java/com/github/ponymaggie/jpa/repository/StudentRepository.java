package com.github.ponymaggie.jpa.repository;


import com.github.ponymaggie.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    Long countByName(String name);

    @Query("select u from Student u where u.name = ?1 and u.age = ?2")
    Student getByUsernameAndPassword(String name, String age);
}
