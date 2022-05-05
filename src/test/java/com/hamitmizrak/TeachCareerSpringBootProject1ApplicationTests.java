package com.hamitmizrak;

import com.hamitmizrak.data.entity.EmployeeEntity;
import com.hamitmizrak.data.repository.EmployeeRepository;
import com.hamitmizrak.iotest.ITestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeachCareerSpringBootProject1ApplicationTests {
//class TeachCareerSpringBootProject1ApplicationTests implements ITestData {


    @Autowired
    EmployeeRepository employeeRepository;
 /*
    //SAVE
    @Override
    @Test
    public void testCreate() {
        EmployeeEntity entity=new EmployeeEntity();
        entity.setEmployeeName("employeename44");
        entity.setEmployeeEmail("hamitmizrak@gmail.com");
        employeeRepository.save(entity);

        //eger: 1 id data bulamazsa Exception fırlat: java.util.NoSuchElementException: No value present
        assertNotNull(employeeRepository.findById(1L).get());
    }


    //FIND
    @Override
    @Test
    public void testFindbyId() {
        EmployeeEntity entity=employeeRepository.findById(1L).get();
        //Belirtilen id bulunmazsa: java.util.NoSuchElementException: No value present
        assertEquals("employeename44",entity.getEmployeeName());
    }

    //LIST
    @Override
    @Test
    public void testList() {
     List<EmployeeEntity> entityList= employeeRepository.findAll();
     //java.lang.AssertionError:  Expecting actual:0  to be greater than:
     assertThat(entityList).size().isGreaterThan(0);
    }

    //UPDATE
    @Override
    @Test
    public void testUpdate() {
        EmployeeEntity entity=employeeRepository.findById(1L).get();
        entity.setEmployeeName("employeename55");
        employeeRepository.save(entity);

        //org.opentest4j.AssertionFailedError: expected: not equal but was: <employeename55>
        //unexpected:Beklenen
        assertNotEquals("employeename44",employeeRepository.findById(1L).get().getEmployeeName());

    }

    //DELETE
    @Override
    @Test
    public void testDelete() {
        employeeRepository.deleteById(1L);
        //istenilen data yoksa: No class com.hamitmizrak.data.entity.EmployeeEntity entity with id 1 exists!
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }*/
}
