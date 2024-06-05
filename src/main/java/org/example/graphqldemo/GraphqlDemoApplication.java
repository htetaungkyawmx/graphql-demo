package org.example.graphqldemo;

import lombok.RequiredArgsConstructor;
import org.example.graphqldemo.entity.Author;
import org.example.graphqldemo.entity.Book;
import org.example.graphqldemo.entity.Rating;
import org.example.graphqldemo.repository.AuthorRepository;
import org.example.graphqldemo.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlDemoApplication {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Bean @Transactional @Profile("dev")
    public ApplicationRunner runner() {
        return args -> {
            Author author = new Author("John", "Doe");
            Author author2 = new Author("Jane", "Doe");

            Book book = new Book("Book 1", Rating.TWO_STARS);
            Book book2 = new Book("Book 2", Rating.THREE_STARS);

            Book book3 = new Book("Book 3", Rating.FOUR_STARS);
            Book book4 = new Book("Book 4", Rating.FIVE_STARS);

            author.addBook(book);
            author.addBook(book2);
            author2.addBook(book3);
            author2.addBook(book4);
            authorRepository.save(author);
            authorRepository.save(author2);
//            bookRepository.save(book);
//            bookRepository.save(book2);
//            bookRepository.save(book3);
//            bookRepository.save(book4);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemoApplication.class, args);
    }

}
