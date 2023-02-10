package com.dione.testingmanagebackend.entities;



import com.dione.testingmanagebackend.enums.Resultat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CasDeTest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refCasTest;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Resultat resultat;

    @OneToMany
    private Collection<ScenarioDeTest> scenarioDeTests;

    @OneToMany
    private Collection<Ticket> tickets;


}