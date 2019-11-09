package com.offcn.springboot.service;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.dao.DeptDao;
import com.offcn.springboot.dao.EmployeeDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DeptDao deptDao;

    //登录方法
    @Override
    public Employee login(String ename,String password) {
        System.out.println(employeeDao);
        Employee employee = employeeDao.findByEnameAndPassword(ename,password);
        return employee;
    }

    //查询所有部门信息
    @Override
    public List<Dept> findAllDept() {
        return deptDao.showAllDept();
    }

    //注册
    @Override
    public boolean save(Employee employee) {
        Employee save = employeeDao.save(employee);
        if (save!=null){
            return true;
        }
        return false;
    }

    //分页查看所有信息
    @Override
    public Page<Employee> showAllInfo(Integer currentPage) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"eid");
        Sort sort = Sort.by(order);
        PageRequest pageable = PageRequest.of(currentPage,5,sort);
        Page<Employee> page = employeeDao.findAll(pageable);
        return page;
    }

    //回显数据
    @Override
    public Employee edit(Integer eid) {
        return employeeDao.findByEid(eid);
    }
}
