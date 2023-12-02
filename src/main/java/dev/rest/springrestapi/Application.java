package dev.rest.springrestapi;

import dev.rest.springrestapi.model.Content;
import dev.rest.springrestapi.model.Status;
import dev.rest.springrestapi.model.Type;
import dev.rest.springrestapi.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {
         // insert some data into to the database
            Content content = new Content(1,
                    "Hello, First Blog Post!",
                    "This is first blog post",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    "");
            repository.save(content);
        };
    }

}
