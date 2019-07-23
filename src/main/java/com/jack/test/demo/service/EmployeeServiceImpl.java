package com.jack.test.demo.service;

import com.jack.test.demo.entity.Employee;
import com.jack.test.demo.repository.EmployeeRepository;
import com.jack.test.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public boolean isExists(String email){
        return  employeeRepository.isExist(email);
    }
}
