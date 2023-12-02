package dev.rest.springrestapi.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(
        @Id
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
