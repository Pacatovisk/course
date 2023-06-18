package com.pacatovisk.course.config;

import com.pacatovisk.course.entities.*;
import com.pacatovisk.course.entities.enums.OrderStatus;
import com.pacatovisk.course.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(category1, category2,category3));

        productRepository.saveAll(Arrays.asList(product1,product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1,product2, product3, product4, product5));

        User user1 = new User(null, "Marcelinho", "marcelinho@gmail.com", "7878454488", "4141545454");
        User user2 = new User(null, "Samuel", "samuel@gmail.com", "40028922", "414@454");
        User user3 = new User(null, "Willain", "willian@gmail.com", "40028922", "414@454");

        Order order1 = new Order(null, Instant.parse("2023-01-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2023-02-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2023-03-12T19:53:07Z"), OrderStatus.CANCELED, user3);

        userRepository.saveAll(List.of(user1, user2, user3));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order2, product2, 1, product2.getPrice());
        OrderItem orderItem3 = new OrderItem(order3, product3, 2, product3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2,orderItem3));

        Payment payment1 = new Payment(null, Instant.parse("2023-03-12T19:53:07Z"), order1);
        order1.setPayment(payment1);

        orderRepository.save(order1);
    }
}
