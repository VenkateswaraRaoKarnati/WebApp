package com.SpringMVC.WebEmployeeCrud.service;

import com.SpringMVC.WebEmployeeCrud.model.Employee;
import com.SpringMVC.WebEmployeeCrud.repository.IEmployeeRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repo;

    public EmployeeService(IEmployeeRepository repo)
    {
        this.repo=repo;
    }
    @Override
    public Iterable<Employee> getAllEmployees() {
        Sort sort = Sort.by(Sort.Direction.ASC,"job");
        //Sort data by designation
        Pageable page= PageRequest.of(1,5,sort);


        return repo.findAll();
    }

    @Override
    public String addEmployee(Employee emp) {
        try{
            repo.save(emp);
            return "Registered Successfully";
        }
       catch(DataAccessException dae)
       {
           dae.printStackTrace();
       }
        return "Error";

    }



    @Override
    public Employee findByEmpNo(int empNo) {
        return repo.findByEmpNo(empNo);

    }

    @Override
    public void deleteByEmpNO(int empNo) {
        repo.deleteById(empNo);
    }


//    @Override
//    public void insert()
//    {
//        repo.insert();
//    }
}
