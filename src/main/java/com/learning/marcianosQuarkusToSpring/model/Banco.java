package com.learning.marcianosQuarkusToSpring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banco")
@Data
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBanco")
    private List<Conta> contas;
}
