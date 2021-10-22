/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.repositories.adminRepository;
import com.rentCloud.cloud.app.entities.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class adminService {

    @Autowired
    private adminRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Admin> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param adminId
     * @return
     */
    public Optional<Admin> getAdminService(int adminId) {
        return repository.getOne(adminId);
    }

    /**
     * POST
     *
     * @param admin
     * @return
     */
    public Admin save(Admin admin) {
        //Consulta si se envio el ID
        if (admin.getIdAdmin() == null) {
            return repository.save(admin);
        } else {
            //Consulta si existe el registro enviado
            Optional<Admin> existAdmin = repository.getOne(admin.getIdAdmin());
            if (existAdmin.isPresent()) {
                return admin;

            } else {
                return repository.save(admin);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param admin
     * @return
     */
    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> existAdmin = repository.getOne(admin.getIdAdmin());
            if (existAdmin.isPresent()) {
                if (admin.getName() != null) {
                    existAdmin.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    existAdmin.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    existAdmin.get().setPassword(admin.getPassword());
                }
                return repository.save(existAdmin.get());
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    /**
     * DELETE
     *
     * @param adminId
     * @return
     */
    public boolean delete(int adminId) {
        Boolean response = getAdminService(adminId).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
        return response;
    }
}
