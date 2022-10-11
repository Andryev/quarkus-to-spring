package com.learning.marcianosQuarkusToSpring.repository;


import com.learning.marcianosQuarkusToSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByCpf(String cpf);
}
