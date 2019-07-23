package com.jack.test.demo;

/*
   Mocking with @MockBean
 */


import com.jack.test.demo.entity.Employee;
import com.jack.test.demo.repository.EmployeeRepository;
import com.jack.test.demo.service.EmployeeService;
import com.jack.test.demo.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest  {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration{

        @Bean
        public EmployeeService employeeService (){
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        Employee jack = new Employee();
        jack.setName("jack");

        Mockito.when(employeeRepository.findByName(jack.getName())).thenReturn(jack);
    }

    @Test
    public void whenValidNameThenEmployeeShouldBeFound(){
        String name ="jack";
        Employee found = employeeService.getEmployeeByName(name);

        assertThat(found.getName()).isEqualTo(name);
    }

}
