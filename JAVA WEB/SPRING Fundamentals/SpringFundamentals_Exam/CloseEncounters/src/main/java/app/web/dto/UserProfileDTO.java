package app.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserProfileDTO {

    @Size(min = 2, max = 20, message = "First name length must be between 2 and 20 characters")
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name length must be between 2 and 20 characters")
    private String lastName;

    @Email(message = "Email must be a valid email address")
    private String email;

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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
} 