package com.example.SpringSecurity;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("gowtham", "gowt123@gmail.com", passwordEncoder.encode("9999"), "ROLE_USER,ROLE_ADMIN")));
            log.info("Preloading " + repository.save(new User("sam", "sam@gmail.com", passwordEncoder.encode("sam"), "ROLE_USER")));
        };
    }
}