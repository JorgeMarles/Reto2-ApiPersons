package com.jamarlesf.reto2.infrastructure.out.jpa.repository;

import com.jamarlesf.reto2.infrastructure.out.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonRepository extends JpaRepository<PersonEntity, String> {
    Optional<PersonEntity> findByDocumentId(String documentId);
}
