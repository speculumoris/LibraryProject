package com.kutuphane.controller;

import com.kutuphane.domain.Publisher;
import com.kutuphane.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Map<String,String>> createPublisher(@Valid @RequestBody Publisher publisher) {

        publisherService.createPublisher(publisher);

        Map<String,String> map = new HashMap<>();
        map.put("message","Publisher is created successfully");
        map.put("status","true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAll(){

        List<Publisher> publishers = publisherService.getAll();

        return ResponseEntity.ok(publishers);


    }




}
