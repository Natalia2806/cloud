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
@Table(name = "category")
public class Category implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//decimos que es auto-incremental
    private Integer id;
    @Column(name = "Name", length = 45)
    private String name;
    @Column(name = "Description", length = 45)
    private String description;
    //Una caterogoría pertenece a muchas nubes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    //Ignora la propiedad category para no caer en una redundancia
    @JsonIgnoreProperties("category")
    private List<Cloud> clouds;
}
