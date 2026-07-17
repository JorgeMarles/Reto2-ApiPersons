package com.jamarlesf.reto2.domain.usecase;

import com.jamarlesf.reto2.domain.api.IPersonPersistencePort;
import com.jamarlesf.reto2.domain.exception.DomainException;
import com.jamarlesf.reto2.domain.model.Person;
import com.jamarlesf.reto2.domain.spi.IPersonServicePort;

public class PersonUseCase implements IPersonServicePort {

    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void save(Person person) {
        person.validate();
        Person existing = personPersistencePort.findByEmail(person.getEmail());
        if (existing != null && !existing.getDocumentId().equals(person.getDocumentId())) {
            throw new DomainException("Ya existe una persona con el email: " + person.getEmail());
        }
        personPersistencePort.save(person);
    }

    @Override
    public Person getByDocumentId(String documentId) {
        return personPersistencePort.findByDocumentId(documentId);
    }
}
