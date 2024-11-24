package Students;

public class Student {
 
    private String firstName;
    private String lastName;
    private double grade;


    public Student (String firstName, String lastName, double grade) {
 
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }


    public String getFirstName() {
        return this.firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

  
    public double getGrade() {
        return this.grade;
    }


    @Override
    public String toString() {
        //представя обекта по формата на текст по мой избор
        //"{first name} {last name}: {grade}"
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);

    }

}
