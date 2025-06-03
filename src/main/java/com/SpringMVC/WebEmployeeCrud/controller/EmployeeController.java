package com.SpringMVC.WebEmployeeCrud.controller;

import com.SpringMVC.WebEmployeeCrud.model.Employee;
import com.SpringMVC.WebEmployeeCrud.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service)
    {
        this.service=service;
    }
    @GetMapping("/home")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/empReport")
    public String showEmpReport(Map<String,Object> map)
    {
        Iterable<Employee> empReport = service.getAllEmployees();
        map.put("empReport",empReport);
        return "employee_report";
    }


    @GetMapping("/register")
    public String toRegister(@ModelAttribute("emp") Employee emp)
    {
        return "register_form";
    }

    @PostMapping("/register")
    public String fromRegister(Map<String,Object> map, @ModelAttribute Employee emp)
    {
        String successMessage = service.addEmployee(emp);
        Iterable<Employee> empReport =service.getAllEmployees();
        map.put("empReport",empReport);
        map.put("successMessage",successMessage);
        return "redirect:empReport";
    }

    @GetMapping("/edit")
    public String editEmployee(@ModelAttribute("emp") Employee emp, @RequestParam("empNo") int empNo)
    {
        Employee emp1=service.findByEmpNo(empNo);
        System.out.println(emp1.getEmpNo());
        BeanUtils.copyProperties(emp1,emp);
            return "edit_form";




    }

    @PostMapping("/edit")
    public String edited(@ModelAttribute Employee emp,Map<String,Object> map)
    {
        service.addEmployee(emp);

        Iterable<Employee> empList= service.getAllEmployees();
        map.put("empReport",empList);
        return "employee_report";
    }

    @GetMapping("/delete")
    public  String delete(@RequestParam int empNo)
    {
        service.deleteByEmpNO(empNo);
        return "redirect:empReport";
    }

//    @GetMapping("/insert")
//    public void insert()
//    {
//        service.insert();
//    }
}
