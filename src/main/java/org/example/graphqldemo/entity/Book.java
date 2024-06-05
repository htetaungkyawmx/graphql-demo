package org.example.graphqldemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;
    public Book(String title, Rating rating) {
        this.title = title;
        this.rating = rating;
    }
    @ManyToOne
    private Author author;
}
