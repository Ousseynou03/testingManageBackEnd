package com.dione.testingmanagebackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Releas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refRelease;
    private Date dateLivraison;
    private Date datePrevision;
    private Date dateReelle;

//    @OneToMany(mappedBy = "release",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER )
//    @JsonBackReference
//    private Collection<Ticket> tickets;
}
