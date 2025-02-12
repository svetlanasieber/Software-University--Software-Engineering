package com.paintingscollectors.web.dto;

import com.paintingscollectors.painting.model.Style;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreatePaintingRequest {

    @NotNull(message = "Not null name!")
    @Size(min = 5, max = 40, message = "Name length must be between 5 and 40 characters!")
    private String name;

    @NotNull(message = "Not null author!")
    @Size(min = 5, max = 30, message = "Name length must be between 5 and 30 characters!")
    private String author;

    @NotNull(message = "Not null image url!")
    @URL
    private String imageUrl;

    @NotNull(message = "Not null style!")
    private Style style;
}
