package com.pacatovisk.course.config;

import com.pacatovisk.course.entities.Category;
import com.pacatovisk.course.entities.Order;
import com.pacatovisk.course.entities.User;
import com.pacatovisk.course.entities.enums.OrderStatus;
import com.pacatovisk.course.repositories.CategoryRepository;
import com.pacatovisk.course.repositories.OrderRepository;
import com.pacatovisk.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category1, category2,category3));

        User user1 = new User(null, "Marcelinho", "marcelinho@gmail.com", "7878454488", "4141545454");
        User user2 = new User(null, "Samuel", "samuel@gmail.com", "40028922", "414@454");
        User user3 = new User(null, "Willain", "willian@gmail.com", "40028922", "414@454");

        Order order1 = new Order(null, Instant.parse("2023-01-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2023-02-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2023-03-12T19:53:07Z"), OrderStatus.CANCELED, user3);

        userRepository.saveAll(List.of(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
