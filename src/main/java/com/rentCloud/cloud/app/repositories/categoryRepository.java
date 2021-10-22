/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Category;
import com.rentCloud.cloud.app.repositories.crud.categoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class categoryRepository {

    @Autowired
    private categoryCrudRepository repository;

    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Category> getAll() {
        return (List<Category>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Category> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param category
     * @return Actualiza o guarda un administrador
     */
    public Category save(Category category) {
        return this.repository.save(category);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param category
     */
    public void delete(Category category) {
        this.repository.delete(category);
    }
}
