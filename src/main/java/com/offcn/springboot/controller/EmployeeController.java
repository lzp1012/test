package com.offcn.springboot.controller;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //跳转方法(跳转到注册页面)
    @RequestMapping(value = {"/","index.html"})
    public String login(){
        return "login";
    }

    //goLogin
    @RequestMapping("goLogin")
    public String goLogin(){
        return "login";
    }

    //goRegister
    @RequestMapping("goRegister")
    public String goRegister(){
        return "register";
    }

    //注册
    @RequestMapping("register")
    public String register(Employee employee, ModelMap modelMap){
            employee.setHirdate(new java.util.Date());
            boolean flag = employeeService.save(employee);
            if(flag){
                modelMap.addAttribute("message","注册成功,请登录");
                return "login";
            }else {
                modelMap.addAttribute("message", "注册失败");
                return "register";
            }
    }

    //查询所有部门信息
    @GetMapping("findAllDept")
    @ResponseBody
    public List<Dept> findAllDept(){
        return employeeService.findAllDept();
    }

    //登录方法
    @RequestMapping("login")
    public String login(String ename,String password, Model model, HttpSession httpSession){
        Employee employee = employeeService.login(ename,password);
        if(employee!=null){
            httpSession.setAttribute("user",employee);
            return "redirect:/showAllInfo";
        }else {
            model.addAttribute("message","登录异常");
            return "login";
        }
    }

    //分页查看所有信息
    @GetMapping("showAllInfo")
    public String showAllInfo(@RequestParam(name = "cp",defaultValue = "0") Integer currentPage,Model model){
      /*  List<Employee> employeeList = employeeService.showAllInfo();
        model.addAttribute("list",employeeList);*/
        Page<Employee> employees = employeeService.showAllInfo(currentPage);
        model.addAttribute("pageInfo",employees);
        List<Employee> content = employees.getContent();
        model.addAttribute("employeeList",content);
        return "emp/show";
    }

    //回显数据
    @RequestMapping("edit")
    public String edit(Integer eid,Model model){
        Employee employee = employeeService.edit(eid);
        model.addAttribute("emp",employee);
        return "edit";
    }

}
