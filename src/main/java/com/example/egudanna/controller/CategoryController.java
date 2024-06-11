package com.example.egudanna.controller;

import com.example.egudanna.domain.Category;
import com.example.egudanna.dto.category.CategoryResponse;
import com.example.egudanna.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("category_id") long id) {
        Category category = categoryService.getCategoryById(id);
        CategoryResponse categoryResponse = new CategoryResponse(category.getGenre());
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

}
