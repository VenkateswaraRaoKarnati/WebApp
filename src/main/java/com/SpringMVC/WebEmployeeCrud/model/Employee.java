package com.SpringMVC.WebEmployeeCrud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Entity
@Table
@SQLDelete(sql="Update Employee set status = 'deleted' where emp_no = ?")
@SQLRestriction("status <> 'deleted'")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EmployeeSequence")
    @SequenceGenerator(name="EmployeeSequence",sequenceName="EmployeeSequence",initialValue = 1)


    private Integer empNo;

    private String eName;
    private String job;
    private Double sal;
    private Integer deptNo;
    private String status="Active";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
