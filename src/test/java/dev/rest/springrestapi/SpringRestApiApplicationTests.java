package dev.rest.springrestapi;

import dev.rest.springrestapi.model.Content;
import dev.rest.springrestapi.model.Status;
import dev.rest.springrestapi.model.Type;
import dev.rest.springrestapi.repository.ContentCollectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringRestApiApplicationTests {

    @MockBean
    ContentCollectionRepository repository;

    List<Content> contentList = new ArrayList<Content>();
    @BeforeEach()
    void setUp() {
        contentList = List.of(
                new Content(1,
                    "My Blog Title",
                    "My blog description",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    ""
                ),
                new Content(2,
                        "My Second Blog",
                        "blog description",
                        Status.PUBLISHED,
                        Type.VIDEO,
                        LocalDateTime.now(),
                        null,
                        ""
                ));
    }
    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnAllContent() {
        when(repository.findAll()).thenReturn(contentList);
    }

    @Test
    void shouldReturnContentById() {
        when(repository.findById(1)).thenReturn(Optional.ofNullable(contentList.get(0)));
    }

    @Test
    void shouldReturnNewContentWhenCreated() {
        Content content = new Content(3,"Have a nice day!", "", Status.IN_PROGRESS, Type.COURSE,
                LocalDateTime.now(), null, "");
        when(repository.findById(1)).thenReturn(Optional.of(content));
    }

    @Test
    void shouldReturnWhenCreated() {
        Content content = new Content(3,"Have a nice day!", "", Status.IN_PROGRESS, Type.COURSE,
                LocalDateTime.now(), null, "");
        when(repository.findById(1)).thenReturn(Optional.of(content));
    }

    @Test
    void shouldReturnNullWhenNotFound() {
        when(repository.findById(10)).thenReturn(Optional.empty());
    }

}
