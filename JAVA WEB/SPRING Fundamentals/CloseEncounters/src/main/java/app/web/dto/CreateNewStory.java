package app.web.dto;

import app.story.model.Kind;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateNewStory {

    @NotBlank(message = "")
    @Size(min = 5, max = 25, message = "Title length must be between 5 and 25 characters!")
    private String title;

    @NotBlank(message = "")
    @Size(min = 10, max = 1000, message = "Description length must be between 10 and 1000 characters!")
    private String description;

    @NotNull(message = "You must select an encounter kind!")
    private Kind kind;

    @NotNull(message = "must not be null")
    private LocalDate date;
}
