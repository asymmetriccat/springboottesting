package com.jack.test.demo;


/*
   Testing with @DataJpaTest
 */

import com.jack.test.demo.entity.Employee;
import com.jack.test.demo.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegerationTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByNameThenReturnEmployee(){
        //given
        Employee jack = new Employee();
        jack.setName("jack");
        entityManager.persist(jack);
        entityManager.flush();

        //when
        Employee found = employeeRepository.findByName(jack.getName());

        //then
        assertThat(found.getName()).isEqualTo(jack.getName());
    }
}
