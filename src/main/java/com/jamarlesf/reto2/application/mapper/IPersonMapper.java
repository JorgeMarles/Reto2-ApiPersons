package com.jamarlesf.reto2.application.mapper;

import com.jamarlesf.reto2.application.dto.PersonDto;
import com.jamarlesf.reto2.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPersonMapper {
    Person toPerson(PersonDto dto);
    PersonDto toPersonDto(Person person);
}
