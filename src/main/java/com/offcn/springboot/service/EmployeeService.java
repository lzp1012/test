package com.offcn.springboot.service;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.bean.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    //注册
    boolean save(Employee employee);

    //登录方法
    Employee login(String ename,String password);

    //查询所有部门信息
    List<Dept> findAllDept();

    //分页查看所有信息
    Page<Employee> showAllInfo(Integer currentPage);

    //回显数据
    Employee edit(Integer eid);
}
