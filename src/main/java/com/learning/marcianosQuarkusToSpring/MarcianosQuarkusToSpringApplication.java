package com.learning.marcianosQuarkusToSpring;

import com.learning.marcianosQuarkusToSpring.model.Usuario;
import com.learning.marcianosQuarkusToSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MarcianosQuarkusToSpringApplication  implements ApplicationRunner {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MarcianosQuarkusToSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setCpf("897.551.760-80");
		usuario.setName("Pedro");
		usuario.setRole("USER");
		usuario.setEmail("pedro@gmail.com");
		usuario.setPassword(passwordEncoder.encode("123"));


		Usuario usuario2 = new Usuario();
		usuario2.setCpf("351.103.980-03");
		usuario2.setName("Luiza");
		usuario2.setRole("ADMIN");
		usuario2.setEmail("luiza@gmail.com");
		usuario2.setPassword(passwordEncoder.encode("123"));

		repository.save(usuario);
		repository.save(usuario2);
	}

}
