package com.dreamquest.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamquest.manytomany.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
