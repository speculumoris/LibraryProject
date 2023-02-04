package com.kutuphane.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "each book has a publisher")
    @NotBlank(message = "cannot enter white space")
    private String publisherName;

    private String explanation;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books=new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "publisher")
    private Author author;



}
