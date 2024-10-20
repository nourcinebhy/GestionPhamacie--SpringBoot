package com.nourcine.backend.service;

import com.nourcine.backend.dto.RequestCategory;
import com.nourcine.backend.dto.ResponseCategory;
import com.nourcine.backend.entities.Category;

import java.util.List;

public interface CategoryService {

    List<ResponseCategory>getAllCategory();

    boolean deleteCategory(Long id);
     void createCategory(RequestCategory requestCategory);
    Category updateCategory(Long id, RequestCategory requestCategory);
    ResponseCategory getCategory(Long id);

    long countCategories();
    ResponseCategory getCategoryById(Long id);
}
