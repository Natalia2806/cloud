/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Messages;
import com.rentCloud.cloud.app.repositories.messageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class messageService {
     @Autowired
    private messageRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Messages> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param messageId
     * @return
     */
    public Optional<Messages> getMessagesService(int messageId) {
        return repository.getOne(messageId);
    }

    /**
     * POST
     *
     * @param message
     * @return
     */
    public Messages save(Messages message) {
        //Consulta si se envio el ID
        if (message.getIdMessage()== null) {
            return repository.save(message);
        } else {
            //Consulta si existe el registro enviado
            Optional<Messages> existMessages = repository.getOne(message.getIdMessage());
            if (existMessages.isPresent()) {
                return message;

            } else {
                return repository.save(message);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param message
     * @return
     */
    public Messages update(Messages message) {
        if (message.getIdMessage()!= null) {
            Optional<Messages> existMessages = repository.getOne(message.getIdMessage());
            if (existMessages.isPresent()) {
                if (message.getMessageText() != null) {
                    existMessages.get().setMessageText(message.getMessageText());
                }
                if (message.getClient() != null) {
                    existMessages.get().setClient(message.getClient());
                }
                if (message.getCloud()!= null) {
                    existMessages.get().setCloud(message.getCloud());
                }
                return repository.save(existMessages.get());
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * DELETE
     *
     * @param messageId
     * @return
     */
    public boolean delete(int messageId) {
        Boolean response = getMessagesService(messageId).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
        return response;
    }
}
