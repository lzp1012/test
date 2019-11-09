package com.offcn.springboot.dao;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.bean.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer> {

    //通过eid和ename判断是否登录成功
    public Employee findByEnameAndPassword(String ename,String password);

    //查询所有部门信息
    @Query("from Dept")
    List<Dept> findAllDept();

    //分页查看所有信息
    @Query("from Employee")
    List<Employee> showAllInfo();

    //回显数据
    Employee findByEid(Integer eid);
}
