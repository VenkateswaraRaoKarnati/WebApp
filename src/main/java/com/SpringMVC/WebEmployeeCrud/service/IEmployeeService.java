package com.SpringMVC.WebEmployeeCrud.service;

import com.SpringMVC.WebEmployeeCrud.model.Employee;

import java.util.Optional;

public interface IEmployeeService {
    public Iterable<Employee> getAllEmployees();

    String addEmployee(Employee emp);

//    Employee editEmployee(Employee emp);

    Optional<Employee> findByEmpNo(int empNo);

    void deleteByEmpNO(int empNo);

    //public void insert();
}
