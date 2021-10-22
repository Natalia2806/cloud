/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Category;
import com.rentCloud.cloud.app.repositories.categoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class categoryService {
     @Autowired
    private categoryRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Category> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param categoryId
     * @return
     */
    public Optional<Category> getCategoryService(int categoryId) {
        return repository.getOne(categoryId);
    }

    /**
     * POST
     *
     * @param category
     * @return
     */
    public Category save(Category category) {
        //Consulta si se envio el ID
        if (category.getId() == null) {
            return repository.save(category);
        } else {
            //Consulta si existe el registro enviado
            Optional<Category> existCategory = repository.getOne(category.getId());
            if (existCategory.isPresent()) {
                return category;

            } else {
                return repository.save(category);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param category
     * @return
     */
    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> existCategory = repository.getOne(category.getId());
            if (existCategory.isPresent()) {
                if (category.getName() != null) {
                    existCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    existCategory.get().setDescription(category.getDescription());
                }
                if (category.getClouds() != null) {
                    existCategory.get().setClouds(category.getClouds());
                }
                return repository.save(existCategory.get());
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    /**
     * DELETE
     *
     * @param categoryId
     * @return
     */
    public boolean delete(int categoryId) {
        Boolean response = getCategoryService(categoryId).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
        return response;
    }
}
