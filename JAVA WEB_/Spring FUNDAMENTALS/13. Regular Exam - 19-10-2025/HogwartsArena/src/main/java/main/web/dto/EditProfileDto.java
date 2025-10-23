package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditProfileDto {

    @NotBlank
    @Size(min = 6, max = 12)
    private String username;

    @NotBlank
    @URL
    private String avatarUrl;
}



