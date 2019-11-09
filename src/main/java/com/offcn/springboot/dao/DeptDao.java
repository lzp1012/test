package com.offcn.springboot.dao;

import com.offcn.springboot.bean.Dept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeptDao extends PagingAndSortingRepository<Dept,Integer> {

    //查询所有部门
    @Query("select new Dept(deptno,dname)from Dept")
    List<Dept> showAllDept();
}
