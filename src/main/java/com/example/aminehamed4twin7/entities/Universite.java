package com.example.aminehamed4twin7.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresse;
@OneToOne
Foyer foyer;



}
