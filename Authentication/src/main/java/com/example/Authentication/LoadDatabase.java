package com.example.Authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("gowt", "gowt@gmail.com", "9999")));
      log.info("Preloading " + repository.save(new User("abc", "abc@gmail.com", "abc123")));
      log.info("Preloading " + repository.save(new User("xyz", "xyz@gmail.com", "xyz9999")));
      log.info("Preloading " + repository.save(new User("alpha", "alpha@gmail.com", "abcdef")));
      log.info("Preloading " + repository.save(new User("paul", "paul@gmail.com", "1234")));
    };
  }
}
