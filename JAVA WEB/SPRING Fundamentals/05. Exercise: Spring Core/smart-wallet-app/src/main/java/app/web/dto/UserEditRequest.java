package app.web.dto;

import app.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class UserEditRequest {

    @Size(max = 50)
    private String firstName;
    @Size(max = 50)
    private String lastName;
    @Email
    private String email;
    @URL
    private String profilePicture;

    public static UserEditRequest buildFromUser(User user) {

        return UserEditRequest.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture())
                .build();
    }
}
