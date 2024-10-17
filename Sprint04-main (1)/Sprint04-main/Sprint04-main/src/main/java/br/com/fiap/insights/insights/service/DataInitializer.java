package br.com.fiap.insights.insights.service;

import br.com.fiap.insights.insights.model.Role;
import br.com.fiap.insights.insights.repository.ClienteRepository;
import br.com.fiap.insights.insights.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ClienteRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            adminRole.setLabel("Admin");
            roleRepository.save(adminRole);
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            userRole.setLabel("User");
            roleRepository.save(userRole);

        };
    }
}