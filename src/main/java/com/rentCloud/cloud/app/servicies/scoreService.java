/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.servicies;

import com.rentCloud.cloud.app.entities.Score;
import com.rentCloud.cloud.app.repositories.scoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naty
 */
@Service
public class scoreService {
     @Autowired
    private scoreRepository repository;

    /**
     *
     * @return Retorna todos los administradores
     */
    public List<Score> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param scoreId
     * @return
     */
    public Optional<Score> getScoreService(int scoreId) {
        return repository.getOne(scoreId);
    }

    /**
     * POST
     *
     * @param score
     * @return
     */
    public Score save(Score score) {
        //Consulta si se envio el ID
        if (score.getIdScore() == null) {
            return repository.save(score);
        } else {
            //Consulta si existe el registro enviado
            Optional<Score> existScore = repository.getOne(score.getIdScore());
            if (existScore.isPresent()) {
                return score;

            } else {
                return repository.save(score);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param score
     * @return
     */
    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> existScore = repository.getOne(score.getIdScore());
            if (existScore.isPresent()) {
                if (score.getMessageText()!= null) {
                    existScore.get().setMessageText(score.getMessageText());
                }
                if (score.getReservation()!= null) {
                    existScore.get().setReservation(score.getReservation());
                }
                if (score.getScore()!= null) {
                    existScore.get().setScore(score.getScore());
                }
                return repository.save(existScore.get());
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    /**
     * DELETE
     *
     * @param scoreId
     * @return
     */
    public boolean delete(int scoreId) {
        Boolean response = getScoreService(scoreId).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return response;
    }
}
