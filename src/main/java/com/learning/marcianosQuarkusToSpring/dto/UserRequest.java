package com.learning.marcianosQuarkusToSpring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

    @NotBlank(message = "O nome nao pode ser vazio")
    private String nome;

    @NotBlank(message = "O cpf nao pode ser vazio")
   // @Size(min = 11, max = 15, message = "Formato de cpf invalido")
    @CPF
    private String cpf;

    @Email(message = "Formato de email invalido")
    private String email;

}
