package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {


    private String name;
    private List<Employee> employees;

    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getDepartmentSalary() {
        double sum = 0;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Highest Average Salary: ").append(this.name).append(System.lineSeparator());
        for (Employee employee : this.employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
