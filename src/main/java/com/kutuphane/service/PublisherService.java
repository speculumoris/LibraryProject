package com.kutuphane.service;

import com.kutuphane.domain.Publisher;
import com.kutuphane.exception.ConflictException;
import com.kutuphane.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAll() {

        return publisherRepository.findAll();

    }

    public void createPublisher(Publisher publisher) {

        if (publisherRepository.existsByPublisherName(publisher.getPublisherName())) {
            throw new ConflictException("Publisher name is already exists");
        }

        publisherRepository.save(publisher);

    }
}
