package com.learning.marcianosQuarkusToSpring.service;

import com.learning.marcianosQuarkusToSpring.dto.UserRequest;
import com.learning.marcianosQuarkusToSpring.dto.UserResponse;
import com.learning.marcianosQuarkusToSpring.model.Conta;
import com.learning.marcianosQuarkusToSpring.model.Usuario;
import com.learning.marcianosQuarkusToSpring.repository.ContaRepository;
import com.learning.marcianosQuarkusToSpring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final ContaRepository contaRepository;


    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public UserResponse save(UserRequest dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setName(dto.getNome());

        repository.save(usuario);

        return toUserResponse(usuario);
    }

    private UserResponse toUserResponse(Usuario usuario) {
        return UserResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getName())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .build();
    }

    public boolean delete(Long id) {

        Optional<Usuario> user = repository.findById(id);

        if (user.isPresent()) {
            repository.delete(user.get());

            return true;
        } else {
            return false;
        }
    }

    public Optional<Usuario> update(Long id, UserRequest dto) {
        Optional<Usuario> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {

            Usuario usuario = optionalUser.get();
            usuario.setCpf(dto.getCpf());
            usuario.setEmail(dto.getEmail());
            usuario.setName(dto.getNome());
            repository.save(usuario);

            return Optional.of(usuario);
        } else {

            return Optional.empty();
        }
    }

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }

    public Conta saveConta(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }

    public Optional<Usuario> findByCpf(String cpf) {
        return this.repository.findByCpf(cpf);
    }
}
