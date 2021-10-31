/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Category;
import com.rentCloud.cloud.app.servicies.categoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Naty
 */
@RestController
@RequestMapping("Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private categoryService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Category> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Category> getOne(@PathVariable("id") int categoryId) {
        return service.getCategoryService(categoryId);
    }

    /**
     * POST
     *
     * @param category
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    /**
     * PUT
     *
     * @param category
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    /**
     * DELETE
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return service.delete(categoryId);
    }
}
