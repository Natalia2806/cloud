/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.controllers;

import com.rentCloud.cloud.app.entities.Score;
import com.rentCloud.cloud.app.servicies.scoreService;
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
@RequestMapping("Score")
@CrossOrigin(origins = "*")

public class ScoreController {
   @Autowired
    private scoreService service;

    /**
     * GET
     *
     * @return
     */
    @GetMapping("/all")
    public List<Score> getAll() {
        return service.getAll();
    }

    /**
     * GET/{id}
     *
     * @param scoreId
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Score> getOne(@PathVariable("id") int scoreId) {
        return service.getScoreService(scoreId);
    }

    /**
     * POST
     *
     * @param score
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return service.save(score);
    }

    /**
     * PUT
     *
     * @param score
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score) {
        return service.update(score);
    }

    /**
     * DELETE
     *
     * @param scoreId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int scoreId) {
        return service.delete(scoreId);
    }  
}
