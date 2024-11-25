package org.example.repositories;

import org.example.entities.Employee;
import org.example.entities.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<EmployeeDTO> findByBirthdayBeforeOrderBySalaryDesc(LocalDate year);
}
