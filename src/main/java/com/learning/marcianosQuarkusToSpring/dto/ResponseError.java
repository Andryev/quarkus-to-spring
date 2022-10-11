package com.learning.marcianosQuarkusToSpring.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.ConstraintViolation;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ResponseError {

    private String mensagem;

    private Collection<FieldError> erros;

    public static <T> ResponseError createFrom(Set<ConstraintViolation<T>> constraintViolationSet) {

        List<FieldError> erros = constraintViolationSet
                .stream()
                .map(violation ->
                        FieldError.builder()
                        .field(violation.getPropertyPath().toString())
                        .message(violation.getMessage())
                        .build())
                .collect(Collectors.toList());

        String mensagem = "Validation error(s)";

        return ResponseError.builder()
                .erros(erros)
                .mensagem(mensagem)
                .build();
    }
}
