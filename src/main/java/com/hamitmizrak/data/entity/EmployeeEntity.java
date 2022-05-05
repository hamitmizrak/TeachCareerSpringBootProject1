package com.hamitmizrak.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//LOMBOK
@Data
@NoArgsConstructor

//ENTİTY
@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntiy implements Serializable {
    public final static long serialVersionUID=1L;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_email")
    private String employeeEmail;

    //parametreli constructor
    public EmployeeEntity( String employeeName, String employeeEmail) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
    }
}
