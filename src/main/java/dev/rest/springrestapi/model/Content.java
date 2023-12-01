package dev.rest.springrestapi.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank
        String title,
        String description,
        Status status,
        Type contentType,
        @FutureOrPresent
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        @URL
        String url
) {
}
