package com.offcn.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer eid;
    @Column
    private String ename;

    //部门编号
    @Column
    private Integer deptno;

    @Column
    private Double salary;

    @Column
    private String password;

    @Column
    private Date hirdate;





//    @ManyToOne
//    private Dept dept;

}