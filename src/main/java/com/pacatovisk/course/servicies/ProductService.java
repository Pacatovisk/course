package com.pacatovisk.course.servicies;

import com.pacatovisk.course.entities.Product;
import com.pacatovisk.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id " + id + "!"));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product user) {
        productRepository.save(user);
    }
}
