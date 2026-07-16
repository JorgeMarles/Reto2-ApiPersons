package com.jamarlesf.reto2.application.handler.impl;

import com.jamarlesf.reto2.application.dto.PersonDto;
import com.jamarlesf.reto2.application.handler.IPersonHandler;
import com.jamarlesf.reto2.application.mapper.IPersonMapper;
import com.jamarlesf.reto2.domain.model.Person;
import com.jamarlesf.reto2.domain.spi.IPersonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonHandler implements IPersonHandler {

    private final IPersonServicePort personServicePort;
    private final IPersonMapper personMapper;

    @Override
    public void save(PersonDto personDto) {
        Person person = personMapper.toPerson(personDto);
        personServicePort.save(person);
    }

    @Override
    public PersonDto getByDocumentId(String documentId) {
        return personMapper.toPersonDto(personServicePort.getByDocumentId(documentId));
    }
}
