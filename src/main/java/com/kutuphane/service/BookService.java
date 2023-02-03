package com.kutuphane.service;

import com.kutuphane.domain.Book;
import com.kutuphane.dto.BookDTO;
import com.kutuphane.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(Book book) {
       // Book book= new Book();

       // book.setBookName(bookDTO.getBookName());
       // book.setSerialName(bookDTO.getSerialName());
       // book.setSerialNo(bookDTO.getSerialNo());
       // book.setSubtitle(bookDTO.getSubtitle());
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
