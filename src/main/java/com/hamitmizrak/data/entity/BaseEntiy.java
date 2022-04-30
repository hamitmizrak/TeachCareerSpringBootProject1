package com.hamitmizrak.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseEntiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,updatable = false)
    private Long id;

    //Kim ekledi
    @Column(name="created_by")
    @CreatedBy
    private String createdBy;

    //Kim ne zaman ekledi
    @Column(name="created_date")
    @CreatedDate
    public java.util.Date createdDate;

    //Kim guncelledi
    @Column(name="updated_by")
    @LastModifiedBy
    private String updateBy;

    //Kim ne zaman gucelledi
    @Column(name="update_date")
    @LastModifiedDate
    public java.util.Date updateDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="created_date",updatable = false)
    private Date date;
}
