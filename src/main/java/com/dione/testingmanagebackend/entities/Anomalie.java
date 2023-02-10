package com.dione.testingmanagebackend.entities;


import com.dione.testingmanagebackend.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Anomalie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refAnomalie;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Criticite criticite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Priorite priorite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Statut statut;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EnCours enCours;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Cloturee cloturee;

    @OneToMany
    private Collection<Ticket> tickets;


}