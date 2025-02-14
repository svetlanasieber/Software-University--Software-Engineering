import entities.Employee;

import javax.persistence.EntityManager;

public class E05EmployeesFromDepartment {
    private static final String PRINT_FORMAT = "%s %s from %s - $%f.02";

    public static void main(String[] args) {
        Connector.createEntityManager()
                .createQuery("FROM Employee WHERE department.name = :dName ORDER BY salary, id", Employee.class)
                .setParameter("dName", "Research and Development")
                .getResultList()
                .forEach(Employee::printFullNameDepartmentNameAndSalary);
    }
}