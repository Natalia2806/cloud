/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Client;
import com.rentCloud.cloud.app.repositories.clientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class clientService {

    @Autowired
    private clientRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Client> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param clientId
     * @return
     */
    public Optional<Client> getClientService(int clientId) {
        return repository.getOne(clientId);
    }

    /**
     * POST
     *
     * @param category
     * @return
     */
    public Client save(Client category) {
        //Consulta si se envio el ID
        if (category.getIdClient()== null) {
            return repository.save(category);
        } else {
            //Consulta si existe el registro enviado
            Optional<Client> existClient = repository.getOne(category.getIdClient());
            if (existClient.isPresent()) {
                return category;

            } else {
                return repository.save(category);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param client
     * @return
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> existClient = repository.getOne(client.getIdClient());
            if (existClient.isPresent()) {
                if (client.getName() != null) {
                    existClient.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    existClient.get().setEmail(client.getEmail());
                }
                if (client.getMessages() != null) {
                    existClient.get().setMessages(client.getMessages());
                }
                if (client.getAge() != null) {
                    existClient.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    existClient.get().setPassword(client.getPassword());
                }
                if (client.getReservations() != null) {
                    existClient.get().setReservations(client.getReservations());
                }
                return repository.save(existClient.get());
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * DELETE
     *
     * @param clientId
     * @return
     */
    public boolean delete(int clientId) {
        Boolean response = getClientService(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return response;
    }
}
