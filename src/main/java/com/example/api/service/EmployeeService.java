package com.example.api.service;

import com.example.api.entity.Employee;
import com.example.api.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database");
        return repository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if (repository.findByEmail(employee.getEmail()).isPresent()) {
            log.warn("Attempted to create employee with existing email: {}", employee.getEmail());
            throw new IllegalArgumentException("Email already exists");
        }
        log.info("Saving new employee: {}", employee.getName());
        return repository.save(employee);
    }
}
