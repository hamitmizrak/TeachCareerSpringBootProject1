package com.hamitmizrak.data.repository;


import com.hamitmizrak.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findEmployeeEntitiesByEmployeeNameStartsWith(String employeeName);
    List<EmployeeEntity> findEmployeeEntitiesByEmployeeNameEndsWith(String employeeName);
    List<EmployeeEntity> findEmployeeEntitiesByEmployeeNameEquals(String employeeName);
    List<EmployeeEntity> findEmployeeEntitiesByEmployeeNameLike(String employeeName);
}
