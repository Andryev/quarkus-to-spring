package com.learning.marcianosQuarkusToSpring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/*
field: email
message: email invalido
 */
@Data
@Builder
public class FieldError {

    @JsonProperty("campo")
    private String field;

    @JsonProperty("mensagem")
    private String message;

}
