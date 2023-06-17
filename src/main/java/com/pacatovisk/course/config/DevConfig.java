package com.pacatovisk.course.config;

import com.pacatovisk.course.entities.User;
import com.pacatovisk.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Marcelinho", "marcelinho@gmail.com", "7878454488", "4141545454");
        User user2 = new User(null, "Samuel", "samuel@gmail.com", "40028922", "414@454");

        userRepository.saveAll(List.of(user1, user2));
    }
}
