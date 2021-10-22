/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Messages;
import com.rentCloud.cloud.app.repositories.crud.messageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class messageRepository {
    
    @Autowired
    private messageCrudRepository repository;
    
    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Messages> getAll() {
        return (List<Messages>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Messages> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param messages
     * @return Actualiza o guarda un administrador
     */
    public Messages save(Messages messages) {
        return this.repository.save(messages);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param messages
     */
    public void delete(Messages messages) {
        this.repository.delete(messages);
    }
    
}
