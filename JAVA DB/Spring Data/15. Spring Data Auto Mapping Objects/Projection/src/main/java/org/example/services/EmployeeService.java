package org.example.services;

import org.example.entities.Employee;
import org.example.entities.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findEmployeesBornBefore(int year);

    void save(Employee employee);

    List<Employee> findAll();
}
