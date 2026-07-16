package com.jamarlesf.reto2.infrastructure.out.jpa.mapper;

import com.jamarlesf.reto2.domain.model.Person;
import com.jamarlesf.reto2.infrastructure.out.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IPersonEntityMapper {
    PersonEntity toEntity(Person person);
    Person toPerson(PersonEntity personEntity);
}
