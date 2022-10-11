package com.learning.marcianosQuarkusToSpring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="cpf", unique = true)
    private String cpf;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "titular")
    @JoinColumn(name = "contaDoUsuario")
    Conta contaDoUsuario;
}
