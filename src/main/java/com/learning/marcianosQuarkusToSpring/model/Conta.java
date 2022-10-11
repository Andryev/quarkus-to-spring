package com.learning.marcianosQuarkusToSpring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contas")
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero")
    private Integer numero;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular")
    private Usuario titular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBanco")
    private Banco banco;

}
