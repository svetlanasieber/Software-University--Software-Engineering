package org.example;

import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        Address address = new Address("Main street", 15, "Sofia", "Bulgaria");

        Employee manager = new Employee("MANAGER-FIRST-NAME", "MANAGER-LAST-NAME", BigDecimal.valueOf(20000), LocalDate.now(), address, true);

        Employee employee1 = new Employee("Employee1", "lastNameE1", BigDecimal.valueOf(5000), LocalDate.now(), address, true);
        Employee employee2 = new Employee("Employee2", "lastNameE2", BigDecimal.valueOf(6000), LocalDate.now(), address, true);
        Employee employee3 = new Employee("Employee3", "lastNameE3", BigDecimal.valueOf(7000), LocalDate.now(), address, true);
        Employee employee4 = new Employee("Employee4", "lastNameE4", BigDecimal.valueOf(8000), LocalDate.now(), address, true);
        Employee employee5 = new Employee("Employee5", "lastNameE5", BigDecimal.valueOf(9000), LocalDate.now(), address, true);

        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        ManagerDTO dto = modelMapper.map(manager, ManagerDTO.class);
        System.out.println(dto);
    }
}