package com.jamarlesf.reto2.domain.spi;

import com.jamarlesf.reto2.domain.model.Person;

public interface IPersonServicePort {
    void save(Person person);
    Person getByDocumentId(String documentId);
}
