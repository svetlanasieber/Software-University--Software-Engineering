package org.example.services;

import org.example.entities.Employee;
import org.example.entities.dto.EmployeeDTO;
import org.example.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDTO> findEmployeesBornBefore(int year) {
        LocalDate localDate = LocalDate.of(1990, 1, 1);
        return this.employeeRepository.findByBirthdayBeforeOrderBySalaryDesc(localDate);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
