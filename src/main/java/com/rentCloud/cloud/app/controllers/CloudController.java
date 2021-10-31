/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Cloud;
import com.rentCloud.cloud.app.servicies.cloudService;
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
@RequestMapping("Cloud")
@CrossOrigin(origins = "*")
public class CloudController {
    @Autowired
    private cloudService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Cloud> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param cloudId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Cloud> getOne(@PathVariable("id") int cloudId) {
        return service.getCloudService(cloudId);
    }

    /**
     * POST
     *
     * @param cloud
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) {
        return service.save(cloud);
    }

    /**
     * PUT
     *
     * @param cloud
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud) {
        return service.update(cloud);
    }

    /**
     * DELETE
     *
     * @param cloudId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cloudId) {
        return service.delete(cloudId);
    } 
}
