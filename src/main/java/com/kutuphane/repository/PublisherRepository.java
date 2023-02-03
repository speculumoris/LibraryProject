package com.kutuphane.repository;

import com.kutuphane.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {


    boolean existsByPublisherName(String publisherName);



}
