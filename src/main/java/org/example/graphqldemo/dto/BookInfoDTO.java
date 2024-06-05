package org.example.graphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.graphqldemo.entity.Rating;

@Getter
@Setter
@AllArgsConstructor
public class BookInfoDTO {
    private int id;
    private String title;
    private Rating rating;
    private AuthorDTO author;
}
