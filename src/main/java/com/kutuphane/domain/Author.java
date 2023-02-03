package com.kutuphane.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "each book has a author")
    @NotBlank(message = "cannot enter white space")
    private String authorName;

    @NotNull(message = "cannot leave null")
    @NotBlank(message = "cannot enter white space")
    private String authorSurname;
    private String explanation;

    @JsonIgnore
    @OneToMany(mappedBy = "authorName")
    private List<Book> bookName;




}
