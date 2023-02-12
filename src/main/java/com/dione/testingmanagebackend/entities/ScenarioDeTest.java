package com.dione.testingmanagebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ScenarioDeTest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refScenario;
    @Column(length = 300)
    private String scenario;

    @ManyToOne
    private CasDeTest casDeTest;
}