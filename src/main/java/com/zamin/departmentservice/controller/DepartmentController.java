package com.zamin.departmentservice.controller;

import com.zamin.departmentservice.client.EmployeeClient;
import com.zamin.departmentservice.model.Department;
import com.zamin.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger((DepartmentController.class));
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;
    @PostMapping("/add")
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}",department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/getAll")
    public List<Department> finadAll(){
        LOGGER.info("Department find");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department findBy id: {}",id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department find with Employees");
        List<Department> departments = departmentRepository.findAll();

        departments.forEach(department -> department.setEmployees(
                employeeClient.findByDepartmentId(department.getId())));
    return departments;
    }
}

