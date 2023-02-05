package com.kutuphane.service;

import com.kutuphane.domain.Book;
import com.kutuphane.dto.BookDTO;
import com.kutuphane.exception.ResourceNotFoundexception;
import com.kutuphane.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;


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

    public void updateBook(Long id, BookDTO bookDTO) {
        Book book=findByIdBook(id);
        if(bookDTO.getBookName()!=null) book.setBookName(bookDTO.getBookName());
        if(bookDTO.getSerialName()!=null) book.setSerialName(bookDTO.getSerialName());
        if(bookDTO.getSerialNo()!=null) book.setSerialNo(bookDTO.getSerialNo());
        if(bookDTO.getSubtitle()!=null)book.setSubtitle(bookDTO.getSubtitle());
        bookRepository.save(book);
    }

    public Book findByIdBook(Long id) {
       return bookRepository.findById(id).
               orElseThrow(()-> new ResourceNotFoundexception("Böyle bir id bulunamadı"));
    }


    public void deleteBook(Long id) {
        Book book=findByIdBook(id);
        bookRepository.delete(book);
    }
}
