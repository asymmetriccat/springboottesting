package com.jack.test.demo.service;

import com.jack.test.demo.entity.Employee;

import java.util.List;

public interface EmployeeService  {
     Employee getEmployeeById(Long id);
     Employee getEmployeeByName(String name);
     List<Employee> getEmployees();
     boolean isExists(String email);
     Employee save(Employee employee);
}
