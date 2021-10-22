/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Naty
 */
@Data //Genera los get y set
@NoArgsConstructor //Genera el constructor vacio
@AllArgsConstructor //Genera el constructor con argumentos
@Entity
@Table(name = "message")
public class Messages implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//decimos que es auto-incremental
    private Integer idMessage;
    @Column(name = "MessageText")
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "cloudId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cloud cloud;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
}
