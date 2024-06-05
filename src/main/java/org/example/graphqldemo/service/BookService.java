package org.example.graphqldemo.service;

import lombok.RequiredArgsConstructor;
import org.example.graphqldemo.dto.AuthorDTO;
import org.example.graphqldemo.dto.BookInfoDTO;
import org.example.graphqldemo.entity.Author;
import org.example.graphqldemo.entity.Book;
import org.example.graphqldemo.entity.Rating;
import org.example.graphqldemo.repository.AuthorRepository;
import org.example.graphqldemo.repository.BookRepository;
import org.example.graphqldemo.util.EntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public BookInfoDTO createBook(String title, Rating rating, String firstName, String lastName) {
        Author author=new Author(firstName,lastName);
        Book book=new Book(title,rating);
        Book book1 =bookRepository.save(book);
        author.addBook(book1);
        Author author1=authorRepository.save(author);
        return new BookInfoDTO(
                book1.getId(),
                book1.getTitle(),
                book1.getRating(),
                new AuthorDTO(author1.getId()
                        ,author1.getFirstName()
                        ,author1.getLastName()
                )
        );
    }

    public List<BookInfoDTO> findAllBook() {
        return bookRepository.findAll()
                .stream()
                .map( b -> new BookInfoDTO(b.getId(),b.getTitle(),b.getRating(), EntityUtil.toAuthorDto(b.getAuthor())))
                .collect(Collectors.toUnmodifiableList());
    }
}
