package bg.softuni.jackson;

public class PersonDTO {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isDeleted;

    public PersonDTO() {}

    public PersonDTO(String firstName, String lastName, int age, boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isDeleted = isDeleted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
