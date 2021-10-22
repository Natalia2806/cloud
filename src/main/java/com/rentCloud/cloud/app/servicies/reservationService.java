/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Reservation;
import com.rentCloud.cloud.app.repositories.reservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class reservationService {

    @Autowired
    private reservationRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservationService(int reservationId) {
        return repository.getOne(reservationId);
    }

    /**
     * POST
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        //Consulta si se envio el ID
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            //Consulta si existe el registro enviado
            Optional<Reservation> existReservation = repository.getOne(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                return reservation;

            } else {
                return repository.save(reservation);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> existReservation = repository.getOne(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                if (reservation.getClient() != null) {
                    existReservation.get().setClient(reservation.getClient());
                }
                if (reservation.getCloud() != null) {
                    existReservation.get().setCloud(reservation.getCloud());
                }
                if (reservation.getDevolutionDate() != null) {
                    existReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getScore() != null) {
                    existReservation.get().setScore(reservation.getScore());
                }
                if (reservation.getStatus() != null) {
                    existReservation.get().setStatus(reservation.getStatus());
                }
                if (reservation.getStratDate() != null) {
                    existReservation.get().setStratDate(reservation.getStratDate());
                }
                return repository.save(existReservation.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * DELETE
     *
     * @param reservationId
     * @return
     */
    public boolean delete(int reservationId) {
        Boolean response = getReservationService(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return response;
    }
}
