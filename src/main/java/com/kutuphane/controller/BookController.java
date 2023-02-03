package com.kutuphane.controller;

import com.kutuphane.domain.Book;
import com.kutuphane.dto.BookDTO;
import com.kutuphane.service.AuthorService;
import com.kutuphane.service.BookService;
import com.kutuphane.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/createbook")
    public ResponseEntity<String> createBook(@Valid @RequestBody Book book){

        bookService.createBook(book);
        String message ="Book has created";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        List<Book> book=bookService.getAll();
        return ResponseEntity.ok(book);
    }


}
