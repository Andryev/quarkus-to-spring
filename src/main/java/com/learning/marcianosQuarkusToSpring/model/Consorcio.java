package com.learning.marcianosQuarkusToSpring.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consorcio")
@Data
public class Consorcio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="consorciado")
    List<Usuario> consorciado;

}
