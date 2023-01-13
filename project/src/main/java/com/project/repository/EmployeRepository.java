package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

}
