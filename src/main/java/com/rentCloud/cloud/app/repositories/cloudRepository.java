/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Cloud;
import com.rentCloud.cloud.app.repositories.crud.cloudCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class cloudRepository {
    @Autowired
    private cloudCrudRepository repository;
    
    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Cloud> getAll() {
        return (List<Cloud>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Cloud> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param cloud
     * @return Actualiza o guarda un administrador
     */
    public Cloud save(Cloud cloud) {
        return this.repository.save(cloud);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param cloud
     */
    public void delete(Cloud cloud) {
        this.repository.delete(cloud);
    }
    
}
