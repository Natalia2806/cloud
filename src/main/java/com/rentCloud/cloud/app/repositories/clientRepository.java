/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Client;
import com.rentCloud.cloud.app.repositories.crud.clientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class clientRepository {

    @Autowired
    private clientCrudRepository repository;

    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Client> getAll() {
        return (List<Client>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Client> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param client
     * @return Actualiza o guarda un administrador
     */
    public Client save(Client client) {
        return this.repository.save(client);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param client
     */
    public void delete(Client client) {
        this.repository.delete(client);
    }
}
