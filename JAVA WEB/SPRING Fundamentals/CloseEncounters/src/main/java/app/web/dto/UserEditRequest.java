package app.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class UserEditRequest {

    @Size(min = 2, max = 20, message = "First name be between 2 and 20 characters!")
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters!")
    private String lastName;

    @Email(message = "Enter valid email address")
    private String email;

    @URL(message = "Enter valid URL link")
    private String profilePicture;
}