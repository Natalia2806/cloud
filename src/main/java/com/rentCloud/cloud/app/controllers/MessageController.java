/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Messages;
import com.rentCloud.cloud.app.servicies.messageService;
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
@RequestMapping("Message")
@CrossOrigin(origins = "*")

public class MessageController {
    @Autowired
    private messageService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Messages> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param messageId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Messages> getOne(@PathVariable("id") int messageId) {
        return service.getMessagesService(messageId);
    }

    /**
     * POST
     *
     * @param message
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages message) {
        return service.save(message);
    }

    /**
     * PUT
     *
     * @param message
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages update(@RequestBody Messages message) {
        return service.update(message);
    }

    /**
     * DELETE
     *
     * @param messageId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return service.delete(messageId);
    } 
}
