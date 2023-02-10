package com.dione.testingmanagebackend.entities;

import com.dione.testingmanagebackend.enums.Types;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refTicket;
    private String titre;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Types type;
    @ManyToOne
    @JsonManagedReference
    private Release release;
    @ManyToOne
    private Testeur testeur;
    @ManyToOne
    private CasDeTest casDeTest;
    @ManyToOne
    private Anomalie anomalie;


}
