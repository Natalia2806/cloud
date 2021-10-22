/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentCloud.cloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Cloud")
public class Cloud implements Serializable { //convertimos objetos a Json y viceversa

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//decimos que es auto-incremental
    private Integer id;
    @Column(name = "Name", length = 45, nullable = false)
    private String name;
    @Column(name = "Brand", length = 45, unique = true)
    private String brand;
    @Column(name = "Year", length = 45, unique = true)
    private Integer year;
    @Column(name = "Description", length = 45, unique = true)
    private String description;
    //Muchas nubes pertenecen a una categoria
    @ManyToOne
    //Anotacion que añade una llave foranea
    @JoinColumn(name = "categoryId")
    //Ignoramos la propiedad cloud para no caer en una redundancia
    @JsonIgnoreProperties("clouds")
    private Category category;
    
 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud", "client"})
    private List<Messages> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cloud")
    @JsonIgnoreProperties({"cloud", "messages"})
    private List<Reservation> reservations;
}
