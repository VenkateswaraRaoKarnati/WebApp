package com.SpringMVC.WebEmployeeCrud.repository;

import com.SpringMVC.WebEmployeeCrud.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer>, CrudRepository<Employee,Integer> {


    Optional<Employee> findByEmpNo(int empNo);
}
