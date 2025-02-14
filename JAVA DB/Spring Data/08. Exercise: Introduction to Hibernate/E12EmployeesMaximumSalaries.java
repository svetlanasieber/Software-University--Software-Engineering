import javax.xml.transform.Result;

public class E12EmployeesMaximumSalaries {
    public static void main(String[] args) {
        // result with object array
        Connector.createEntityManager()
                .createQuery("SELECT department.name, max(salary)" +
                        " FROM Employee " +
                        " GROUP BY department.name" +
                        " HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(objects -> System.out.println(objects[0] + " " + objects[1]));

        System.out.println(System.lineSeparator());

        // result with custom POJO
        Connector.createEntityManager()
                .createQuery("SELECT NEW entities.models.Result(department.name, MAX(salary))" +
                        " FROM Employee" +
                        " GROUP BY department.name" +
                        " HAVING MAX(salary) NOT BETWEEN 30000 AND 70000", Result.class)
                .getResultList()
                .forEach(System.out::println);
    }
}