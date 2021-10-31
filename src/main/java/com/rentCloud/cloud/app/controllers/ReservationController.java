/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Reservation;
import com.rentCloud.cloud.app.repositories.ContadorClientes;
import com.rentCloud.cloud.app.servicies.StatusReservas;
import com.rentCloud.cloud.app.servicies.reservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Naty
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")

public class ReservationController {
    @Autowired
    private reservationService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param reservationId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Reservation> getOne(@PathVariable("id") int reservationId) {
        return service.getReservationService(reservationId);
    }

    /**
     * POST
     *
     * @param reservation
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }

    /**
     * PUT
     *
     * @param reservation
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    /**
     * DELETE
     *
     * @param reservationId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return service.delete(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return service.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return service.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return service.reporteClientesServicio();
    }

}
