/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Client;
import com.rentCloud.cloud.app.servicies.clientService;
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
@RequestMapping("Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private clientService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param clientId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Client> getOne(@PathVariable("id") int clientId) {
        return service.getClientService(clientId);
    }

    /**
     * POST
     *
     * @param client
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    /**
     * PUT
     *
     * @param client
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return service.update(client);
    }

    /**
     * DELETE
     *
     * @param clientId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return service.delete(clientId);
    } 
}
