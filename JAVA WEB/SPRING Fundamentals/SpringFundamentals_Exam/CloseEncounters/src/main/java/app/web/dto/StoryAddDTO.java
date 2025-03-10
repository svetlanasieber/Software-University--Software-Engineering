package app.web.dto;

import app.story.model.Kind;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StoryAddDTO {

    @Size(min = 5, max = 25, message = "Title length must be between 5 and 25 characters!")
    private String title;

    @Size(min = 10, max = 1000, message = "Description length must be between 10 and 1000 characters!")
    private String description;

    @NotNull(message = "You must select an encounter kind!")
    private Kind kind;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "must not be null")
    private LocalDate date;

    public StoryAddDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
} 