package org.example.graphqldemo.util;

import org.example.graphqldemo.dto.AuthorDTO;
import org.example.graphqldemo.dto.BookDTO;
import org.example.graphqldemo.entity.Author;
import org.example.graphqldemo.entity.Book;
import org.springframework.beans.BeanUtils;

public class EntityUtil {
    public static BookDTO tobookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book,bookDTO);
        return bookDTO;
    }
    public static Book toBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO,book);
        return book;
    }
    public static AuthorDTO toAuthorDto(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        BeanUtils.copyProperties(author,authorDTO);
        return authorDTO;
    }
    public static Author ToAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO,author);
        return author;
    }
}
