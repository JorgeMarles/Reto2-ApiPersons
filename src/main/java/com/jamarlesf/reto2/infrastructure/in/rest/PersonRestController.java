package com.jamarlesf.reto2.infrastructure.in.rest;

import com.jamarlesf.reto2.application.dto.PersonDto;
import com.jamarlesf.reto2.application.handler.IPersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonRestController {

    private final IPersonHandler personHandler;

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody PersonDto personDto) {
        personHandler.save(personDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{documentId}")
    public ResponseEntity<PersonDto> getPersonByDocumentId(
            @PathVariable String documentId) {
        return ResponseEntity.ok(personHandler.getByDocumentId(documentId));
    }
}
