package bg.softuni.employees.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private List<EmployeeDTO> staff;

    public ManagerDTO() {}

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> staff) {
        this.staff = staff;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        String formattedStaff = staff.stream()
                .map(s -> " - " + s.toString())
                .collect(Collectors.joining("\n"));

        return String.format("%s %s | Employees: %d%n%s",
            firstName, lastName, staff.size(), formattedStaff
        );
    }
}
