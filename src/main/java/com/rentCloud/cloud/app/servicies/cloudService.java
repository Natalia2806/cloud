/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Cloud;
import com.rentCloud.cloud.app.repositories.cloudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class cloudService {
      @Autowired
    private cloudRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Cloud> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param cloudId
     * @return
     */
    public Optional<Cloud> getCloudService(int cloudId) {
        return repository.getOne(cloudId);
    }

    /**
     * POST
     *
     * @param cloud
     * @return
     */
    public Cloud save(Cloud cloud) {
        //Consulta si se envio el ID
        if (cloud.getId() == null) {
            return repository.save(cloud);
        } else {
            //Consulta si existe el registro enviado
            Optional<Cloud> existCloud = repository.getOne(cloud.getId());
            if (existCloud.isPresent()) {
                return cloud;

            } else {
                return repository.save(cloud);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param cloud
     * @return
     */
    public Cloud update(Cloud cloud) {
        if (cloud.getId() != null) {
            Optional<Cloud> existCloud = repository.getOne(cloud.getId());
            if (existCloud.isPresent()) {
                if (cloud.getName() != null) {
                    existCloud.get().setName(cloud.getName());
                }
                if (cloud.getBrand() != null) {
                    existCloud.get().setBrand(cloud.getBrand());
                }
                if (cloud.getMessages() != null) {
                    existCloud.get().setMessages(cloud.getMessages());
                }
                if (cloud.getCategory() != null) {
                    existCloud.get().setCategory(cloud.getCategory());
                }
                if (cloud.getDescription()!= null) {
                    existCloud.get().setDescription(cloud.getDescription());
                }
                if (cloud.getReservations() != null) {
                    existCloud.get().setReservations(cloud.getReservations());
                }
                 if (cloud.getYear() != null) {
                    existCloud.get().setYear(cloud.getYear());
                }
                return repository.save(existCloud.get());
            } else {
                return cloud;
            }
        } else {
            return cloud;
        }
    }

    /**
     * DELETE
     *
     * @param cloudId
     * @return
     */
    public boolean delete(int cloudId) {
        Boolean response = getCloudService(cloudId).map(cloud -> {
            repository.delete(cloud);
            return true;
        }).orElse(false);
        return response;
    }
}
