package com.jack.test.demo.repository;

import com.jack.test.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     Employee findByName (String name);
    boolean isExist(String email);
}
