package com.kutuphane.dto;

import com.kutuphane.domain.Author;
import com.kutuphane.domain.Book;
import com.kutuphane.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {

    private String bookName;

    private String subtitle;

    private String serialName;

    private String serialNo;

    private Author author;

    private Publisher publisher;


    public BookDTO(Book book) {

        this.bookName=book.getBookName();
        this.subtitle=book.getSubtitle();
        this.serialName=book.getSerialName();
        this.serialNo=book.getSerialNo();


    }
}
