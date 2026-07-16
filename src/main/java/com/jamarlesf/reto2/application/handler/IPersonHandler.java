package com.jamarlesf.reto2.application.handler;

import com.jamarlesf.reto2.application.dto.PersonDto;

public interface IPersonHandler {
    void save(PersonDto personDto);
    PersonDto getByDocumentId(String documentId);
}
