package app.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class UserProfileDTO {

    @Size(min = 2, max = 20, message = "First name length must be between 2 and 20 characters")
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name length must be between 2 and 20 characters")
    private String lastName;

    @Email(message = "Enter valid email address")
    private String email;

    @Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
    private String password;

    @URL(message = "Must contain a valid URL")
    private String profilePicture;

    public UserProfileDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
} 