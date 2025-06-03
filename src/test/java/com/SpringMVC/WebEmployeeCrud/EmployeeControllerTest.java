package com.SpringMVC.WebEmployeeCrud;

import com.SpringMVC.WebEmployeeCrud.repository.IEmployeeRepository;
import com.SpringMVC.WebEmployeeCrud.service.EmployeeService;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest()
public class EmployeeControllerTest {
    @Mock
    IEmployeeRepository repo;


}
