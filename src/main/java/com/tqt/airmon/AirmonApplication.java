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
public class AirmonApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(AirmonApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("tqtadmin");
        user.setPassword(passwordEncoder.encode("anhyeuem"));
        userRepository.save(user);
        System.out.println(user);
    }


}
