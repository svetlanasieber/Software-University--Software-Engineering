package org.example;

import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        for (int i = 1; i <= 5; i++) {
            Employee employee = new Employee(
                    "FirstName" + i,
                    "LastName" + i,
                    500 * i,
                    null);
            EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
            System.out.println(employeeDTO);
            System.out.println();
        }



    }
}