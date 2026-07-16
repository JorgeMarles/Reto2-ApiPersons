package com.jamarlesf.reto2.domain.usecase;

import com.jamarlesf.reto2.domain.api.IPersonPersistencePort;
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
        personPersistencePort.save(person);
    }

    @Override
    public Person getByDocumentId(String documentId) {
        return personPersistencePort.findByDocumentId(documentId);
    }
}
