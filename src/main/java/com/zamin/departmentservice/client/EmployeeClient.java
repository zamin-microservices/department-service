package com.zamin.departmentservice.client;

import com.zamin.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("employee/departmentID/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id);
}
