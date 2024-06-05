package org.example.graphqldemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.graphqldemo.dto.BookInfoDTO;
import org.example.graphqldemo.entity.Rating;
import org.example.graphqldemo.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @MutationMapping
    public BookInfoDTO createBook(@Argument String title,
                                  @Argument Rating rating,
                                  @Argument String firstName,
                                  @Argument String lastName) {
        return bookService.createBook(title,rating,firstName,lastName);
    }
    @ResponseBody
    @GetMapping("/all-books")
    public List<BookInfoDTO> findAllBooks() {
        return bookService.findAllBook();
    }

    @QueryMapping
    public List<BookInfoDTO> allBooks() {
        return bookService.findAllBook();
    }
}
