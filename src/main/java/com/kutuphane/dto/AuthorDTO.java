package com.kutuphane.dto;

import com.kutuphane.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private String authorName;
    private String authorSurname;
    private String explanation;

    public AuthorDTO(Author author) {
        this.authorName=author.getAuthorName();
        this.authorSurname=author.getAuthorSurname();
        this.explanation=author.getExplanation();
    }
}
