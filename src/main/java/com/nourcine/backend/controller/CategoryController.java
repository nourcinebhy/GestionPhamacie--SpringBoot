package com.nourcine.backend.controller;

import com.nourcine.backend.dto.RequestCategory;
import com.nourcine.backend.dto.ResponseCategory;
import com.nourcine.backend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    //@PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<ResponseCategory>> getAllCategory(){
        List<ResponseCategory> categories = categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }
    @PostMapping()
    public ResponseEntity<Object> addCategory(@RequestBody @Valid RequestCategory request){
        categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message","save success!"));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCategory> getCategoryById(@PathVariable Long id){
       return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable(name = "id")Long id,@RequestBody @Valid RequestCategory request){
        categoryService.updateCategory(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Collections.singletonMap("message","update success!"));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteCategory (@PathVariable Long id){
        boolean deletedCategory =categoryService.deleteCategory(id);
        if(deletedCategory){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete success!")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message","category not exist!")
        );
    }
}
