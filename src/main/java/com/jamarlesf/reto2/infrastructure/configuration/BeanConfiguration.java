package com.jamarlesf.reto2.infrastructure.configuration;

import com.jamarlesf.reto2.domain.api.IPersonPersistencePort;
import com.jamarlesf.reto2.domain.spi.IPersonServicePort;
import com.jamarlesf.reto2.domain.usecase.PersonUseCase;
import com.jamarlesf.reto2.infrastructure.out.jpa.adapter.PersonJpaAdapter;
import com.jamarlesf.reto2.infrastructure.out.jpa.mapper.IPersonEntityMapper;
import com.jamarlesf.reto2.infrastructure.out.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper personEntityMapper;

    @Bean
    public IPersonPersistencePort personPersistencePort() {
        return new PersonJpaAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort() {
        return new PersonUseCase(personPersistencePort());
    }
}
