/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Score;
import com.rentCloud.cloud.app.repositories.crud.scoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class scoreRepository {

    @Autowired
    private scoreCrudRepository repository;

    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Score> getAll() {
        return (List<Score>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Score> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param score
     * @return Actualiza o guarda un administrador
     */
    public Score save(Score score) {
        return this.repository.save(score);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param score
     */
    public void delete(Score score) {
        this.repository.delete(score);
    }
}
