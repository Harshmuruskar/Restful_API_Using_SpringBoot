package com.pirate.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pirate.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
