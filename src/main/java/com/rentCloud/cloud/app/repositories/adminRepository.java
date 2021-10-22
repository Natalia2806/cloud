/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Admin;
import com.rentCloud.cloud.app.repositories.crud.adminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class adminRepository {

    @Autowired
    private adminCrudRepository repository;

    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Admin> getAll() {
        return (List<Admin>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Admin> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param admin
     * @return Actualiza o guarda un administrador
     */
    public Admin save(Admin admin) {
        return this.repository.save(admin);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param admin
     */
    public void delete(Admin admin) {
        this.repository.delete(admin);
    }
}
