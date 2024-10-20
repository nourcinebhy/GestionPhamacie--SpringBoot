package com.nourcine.backend.serviceImpl;

import com.nourcine.backend.dto.RequestCategory;
import com.nourcine.backend.dto.ResponseCategory;
import com.nourcine.backend.entities.Category;
import com.nourcine.backend.repository.CategoryRepository;
import com.nourcine.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ResponseCategory> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<ResponseCategory> categoriesFormatted = new ArrayList<>();
        for (Category category : categories) {
            ResponseCategory categoryF = ResponseCategory.makeCategory(category);
            categoriesFormatted.add(categoryF);
        }
        return categoriesFormatted;
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public void createCategory(RequestCategory requestCategory) {
        Category category= new Category();
       // Category category;
      /* category = Category.builder()
                .name(requestCategory.getName())
                .status(true)
                .build();*/
        category.setName(requestCategory.getName());
        categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, RequestCategory requestCategory) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        if (requestCategory.getName() != null) {
            category.setName(requestCategory.getName()); // Corrected line
        }
        return categoryRepository.save(category);
    }

    @Override
    public ResponseCategory getCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return ResponseCategory.makeCategory(categoryOptional.get());
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    @Override
    public ResponseCategory getCategoryById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        return ResponseCategory.makeCategory(category.get());
    }
    @Override
    public long countCategories() {
        return categoryRepository.count();
    }
}
