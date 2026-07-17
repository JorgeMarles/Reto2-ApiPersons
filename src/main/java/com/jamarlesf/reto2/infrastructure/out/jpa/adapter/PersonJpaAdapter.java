package com.jamarlesf.reto2.infrastructure.out.jpa.adapter;

import com.jamarlesf.reto2.domain.api.IPersonPersistencePort;
import com.jamarlesf.reto2.domain.model.Person;
import com.jamarlesf.reto2.infrastructure.exception.DataNotFoundException;
import com.jamarlesf.reto2.infrastructure.out.jpa.entity.PersonEntity;
import com.jamarlesf.reto2.infrastructure.out.jpa.mapper.IPersonEntityMapper;
import com.jamarlesf.reto2.infrastructure.out.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;

    @Override
    public void save(Person person) {
        PersonEntity personEntity = personEntityMapper.toEntity(person);
        personRepository.save(personEntity);
    }

    @Override
    public Person findByDocumentId(String documentId) {
        Optional<PersonEntity> personEntity = personRepository.findByDocumentId(documentId);
        if (personEntity.isPresent()) {
            return personEntityMapper.toPerson(personEntity.get());
        }
        throw new DataNotFoundException("Persona con documento " + documentId + " no encontrada");
    }

    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email)
                .map(personEntityMapper::toPerson)
                .orElse(null);
    }
}
