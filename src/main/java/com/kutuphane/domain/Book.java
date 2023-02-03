package com.kutuphane.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "each book has a name")
    @NotBlank(message = "Book name cannot blank")
    private String bookName;

    private String subtitle;

    private String serialName;

    @NotNull(message = "each book has a serialNo")
    @NotBlank(message = "serialNo cannot blank")
    @Column(nullable = false)
    private String serialNo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;







}
