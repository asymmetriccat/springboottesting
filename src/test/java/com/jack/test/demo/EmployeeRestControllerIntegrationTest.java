package com.jack.test.demo;
/*
   Unit Testing with @WebMvcTest
 */


import com.jack.test.demo.controller.EmployeeController;
import com.jack.test.demo.entity.Employee;
import com.jack.test.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;


    @Test
    public void givenEmployeesWhenGetEmployeesThenReturnJsonArray() throws Exception{
        Employee jack = new Employee();
        jack.setName("jack");
        Employee jerry = new Employee();
        jerry.setName("jerry");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(jack);
        employeeList.add(jerry);

        given(employeeService.getEmployees()).willReturn(employeeList);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$[1].name").value(jerry.getName()))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value(jack.getName()));

    }

}
