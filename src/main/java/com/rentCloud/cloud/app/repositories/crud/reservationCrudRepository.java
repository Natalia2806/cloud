/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.repositories.crud;


import com.rentCloud.cloud.app.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Naty
 */
public interface reservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
