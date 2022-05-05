package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.business.services.EmployeeServices;
import com.hamitmizrak.data.entity.EmployeeEntity;
import com.hamitmizrak.data.repository.EmployeeRepository;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class EmployeeServivesImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;


    //Model Mapper
    //EntityToDto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto dto=   modelMapper.map(employeeEntity,EmployeeDto.class);
        return dto;
    }

    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity entity=  modelMapper.map(employeeDto,EmployeeEntity.class);
        return entity;
    }

    //CRUD
    //save
    //http://localhost:8080/save/employees
    @Override
    @PostMapping("/save/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity entity  =  DtoToEntity(employeeDto);
        employeeRepository.save(entity);
        log.info("Employee Kaydedildi");
        return employeeDto;
    }

    //list
    //http://localhost:8080/list/employees
    @Override
    @GetMapping("/list/employees")
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> list=new ArrayList<>();
       Iterable<EmployeeEntity> listem= employeeRepository.findAll();
       for(EmployeeEntity entity  : listem){
           EmployeeDto dto=   EntityToDto(entity);
           list.add(dto);
       }
        return list;
    }


    //filter:find
    //http://localhost:8080/find/employees/1
    @Override
    @GetMapping("/find/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById( @PathVariable(name="id") Long id) throws Throwable {
        EmployeeEntity entity=
                (EmployeeEntity) employeeRepository.
                        findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Employee "+id+" id bulamadı !!!"));
        EmployeeDto dto=   EntityToDto(entity);
        return ResponseEntity.ok(dto);
    }


    //Update
    //http://localhost:8080/update/employees/1
    @Override
    @PutMapping("/update/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name="id")  Long id, EmployeeDto employeeDto) throws Throwable {
        //DtoToEntity
        EmployeeEntity entity=   DtoToEntity(employeeDto);

        //findEntity
        EmployeeEntity entityFind=
             employeeRepository.
                        findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Employee "+id+" id bulamadı !!!"));

        //setEntity
        entityFind.setEmployeeName(entity.getEmployeeName());
        entityFind.setEmployeeEmail(entity.getEmployeeEmail());

        EmployeeEntity entity2= employeeRepository.save(entityFind);
        //EntityToDto
        EmployeeDto dto=  EntityToDto(entity2);
        return  ResponseEntity.ok(dto);
    }

    //Delete
    //http://localhost:8080/delete/employees/1
    @Override
    @DeleteMapping("/delete/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name="id")  Long id) {
        //findEntity
        EmployeeEntity entityFind=
                 employeeRepository.
                        findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Employee "+id+" id bulamadı !!!"));

        employeeRepository.delete(entityFind);
        Map<String,Boolean> response=new HashMap<>();
        response.put("silindi",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
