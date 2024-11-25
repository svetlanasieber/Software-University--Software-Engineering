package bg.softuni.entities.dtos;

public class UserNamesDTO {
    private String username;
    private String firstName;
    private String surname;

    public UserNamesDTO() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastname) {
        this.surname = lastname;
    }

    @Override
    public String toString() {
        return "UserNamesDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + surname + '\'' +
                '}';
    }
}
