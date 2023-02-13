package com.dione.testingmanagebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Testeur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesteur;
    private String matricule;
    private String prenom;
    private String nom;

//    @OneToMany(mappedBy = "testeur")
//    private Collection<Ticket> tickets;
}