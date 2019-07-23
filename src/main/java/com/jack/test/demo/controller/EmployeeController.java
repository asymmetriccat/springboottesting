package com.jack.test.demo.controller;

import com.jack.test.demo.entity.Employee;
import com.jack.test.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }
}
