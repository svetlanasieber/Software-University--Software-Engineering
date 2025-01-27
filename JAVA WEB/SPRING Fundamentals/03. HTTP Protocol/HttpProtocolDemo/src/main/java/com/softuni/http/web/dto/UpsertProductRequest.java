package com.softuni.http.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpsertProductRequest {

    private String name;
    private int quantity;
}
