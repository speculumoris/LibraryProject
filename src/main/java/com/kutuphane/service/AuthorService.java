package com.kutuphane.service;

import com.kutuphane.domain.Author;
import com.kutuphane.dto.AuthorDTO;
import com.kutuphane.exception.ResourceNotFoundexception;
import com.kutuphane.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author aut=findAutById(id);

        Author author= new Author();
        author.setAuthorName(authorDTO.getAuthorName());
        author.setId(authorDTO.getId());
        author.setAuthorSurname(authorDTO.getAuthorSurname());
        author.setExplanation(authorDTO.getExplanation());
    }


    public Author findAutById(Long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundexception("There is no author in this id"));
    }

    public void deleteById(Long id) {
        Author aut=findAutById(id);
        authorRepository.delete(aut);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
