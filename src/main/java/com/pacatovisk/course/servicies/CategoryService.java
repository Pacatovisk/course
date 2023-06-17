package com.pacatovisk.course.servicies;

import com.pacatovisk.course.entities.Category;
import com.pacatovisk.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id " + id + "!"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category order) {
        categoryRepository.save(order);
    }
}
