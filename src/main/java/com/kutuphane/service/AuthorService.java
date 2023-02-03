package com.kutuphane.service;

import com.kutuphane.domain.Author;
import com.kutuphane.dto.AuthorDTO;
import com.kutuphane.exception.ConflictException;
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
        boolean exists=authorRepository.existsById(author.getId());
        if(exists){
            throw new ConflictException("There is an other author has this id ");
        }
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author=findAutById(id);

        author.setAuthorName(authorDTO.getAuthorName());
        author.setAuthorSurname(authorDTO.getAuthorSurname());
        author.setExplanation(authorDTO.getExplanation());

        authorRepository.save(author);
    }


    public Author findAutById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundexception("Student not found with id :" + id));
    }

    public void deleteById(Long id) {
        Author aut=findAutById(id);
        authorRepository.delete(aut);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
