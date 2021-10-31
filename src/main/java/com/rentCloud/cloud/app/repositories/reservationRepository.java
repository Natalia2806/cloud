/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories;

import com.rentCloud.cloud.app.entities.Client;
import com.rentCloud.cloud.app.entities.Reservation;
import com.rentCloud.cloud.app.repositories.crud.reservationCrudRepository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservation> ReservacionStatusRepositorio (String status){
        return this.repository.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return this.repository.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = this.repository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }


}
