package com.SpringMVC.WebEmployeeCrud.service;

import com.SpringMVC.WebEmployeeCrud.model.Employee;

public interface IEmployeeService {
    public Iterable<Employee> getAllEmployees();

    String addEmployee(Employee emp);

//    Employee editEmployee(Employee emp);

    Employee findByEmpNo(int empNo);

    void deleteByEmpNO(int empNo);

    //public void insert();
}
