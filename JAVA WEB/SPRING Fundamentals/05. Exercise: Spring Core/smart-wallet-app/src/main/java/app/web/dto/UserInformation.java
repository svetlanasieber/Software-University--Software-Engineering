package app.web.dto;

import app.user.model.Country;
import app.user.model.UserRole;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInformation {

    private UUID id;
    private String username;
    private String email;
    private UserRole role;
    private Country country;
    private boolean isActive;
    private LocalDateTime createdOn;
}
