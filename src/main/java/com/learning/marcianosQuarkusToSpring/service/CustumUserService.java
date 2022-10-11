package com.learning.marcianosQuarkusToSpring.service;

import com.learning.marcianosQuarkusToSpring.model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustumUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userService.findByCpf(username);

        User userDetails = null;

        if (user.isPresent()) {
            Usuario usuario1 = user.get();

            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(usuario1.getRole()));

            userDetails
                    = new User(
                    usuario1.getCpf(), usuario1.getPassword(), authorities
            );
        }

        return userDetails;
    }

}
