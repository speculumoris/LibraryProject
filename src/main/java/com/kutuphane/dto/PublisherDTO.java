package com.kutuphane.dto;

import com.kutuphane.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    private Long id;

    private String publisherName;

    private String explanation;

    public PublisherDTO(Publisher publisher) {
        this.id=publisher.getId();
        this.publisherName=publisher.getPublisherName();
        this.explanation=publisher.getExplanation();
    }
}
