package com.kutuphane.controller;

import com.kutuphane.domain.Author;
import com.kutuphane.dto.AuthorDTO;
import com.kutuphane.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/createauthor")
    public ResponseEntity<String> createAuthor(@Valid @RequestBody Author author){
        authorService.createAuthor(author);
        String message="Author has created";
        return ResponseEntity.ok(message);
    }

    @PutMapping("updateauthor/{id}")
    public ResponseEntity<String> updateAuthor( @PathVariable("id") Long id, @Valid @RequestBody AuthorDTO authorDTO){
        authorService.updateAuthor(id,authorDTO);
        String message="Author has updated successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Author>findAutById(@PathVariable("id") Long id){
        Author author=authorService.findAutById(id);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/deleteauthor/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        authorService.deleteById(id);
        String message= "Author has deleted successfully";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Author>> getAll(){
       List<Author> allAuthor=authorService.getAll();
        return ResponseEntity.ok(allAuthor);
    }
}
