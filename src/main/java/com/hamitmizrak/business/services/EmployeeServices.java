package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

//CRUD
public interface EmployeeServices {


    //save
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    //list
    public List<EmployeeDto> getAllEmployees();

    //filter:find
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //update
    public ResponseEntity<EmployeeDto> updateEmployee(Long id,EmployeeDto employeeDto);

    //delete
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);

    //modelMapper: DTO  to Entity
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtoToEntity(EmployeeDto  employeeDto);
}
