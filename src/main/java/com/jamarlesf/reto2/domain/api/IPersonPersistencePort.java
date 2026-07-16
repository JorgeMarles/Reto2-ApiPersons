package com.jamarlesf.reto2.domain.api;

import com.jamarlesf.reto2.domain.model.Person;

import java.util.Optional;

public interface IPersonPersistencePort {
    void save(Person person);
    Person findByDocumentId(String documentId);
}
