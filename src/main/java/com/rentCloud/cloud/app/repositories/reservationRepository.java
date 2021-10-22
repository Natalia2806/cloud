/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Reservation;
import com.rentCloud.cloud.app.repositories.crud.reservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naty
 */
@Repository
public class reservationRepository {

    @Autowired
    private reservationCrudRepository repository;

    /**
     * SELEC * FROM ADMIN
     *
     * @return Retorna todos los administradores
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) this.repository.findAll();
    }

    /**
     * SELECT * FROM ADMIN WHERE ID= id
     *
     * @param id
     * @return Retorna un administrador por su ID especifico
     */
    public Optional<Reservation> getOne(int id) {
        return this.repository.findById(id);
    }

    /**
     * INSERT & UPDATE
     *
     * @param reservation
     * @return Actualiza o guarda un administrador
     */
    public Reservation save(Reservation reservation) {
        return this.repository.save(reservation);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param reservation
     */
    public void delete(Reservation reservation) {
        this.repository.delete(reservation);
    }

}
