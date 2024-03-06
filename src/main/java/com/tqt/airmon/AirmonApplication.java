package com.tqt.airmon;

import com.tqt.airmon.model.User;
import com.tqt.airmon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableScheduling
@SpringBootApplication
public class AirmonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirmonApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

}
