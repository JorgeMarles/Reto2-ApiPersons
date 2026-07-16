package com.jamarlesf.reto2.domain.model;

import com.jamarlesf.reto2.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String documentId;
    private String name;
    private String email;

    public void validate() {
        validateEmail();
        validateDocumentId();
        validateName();
    }

    private void validateEmail() {
        if (email == null || email.trim().isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")) {
            throw new DomainException("Email inválido: " + email);
        }
    }

    private void validateDocumentId() {
        if(documentId == null || documentId.trim().isEmpty()) {
            throw new DomainException("Documento inválido: "+documentId);
        }
    }

    private void validateName() {
        if(name == null || name.trim().isEmpty()) {
            throw new DomainException("Nombre inválido: "+name);
        }
    }
}
