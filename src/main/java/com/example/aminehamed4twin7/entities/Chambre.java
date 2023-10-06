package com.example.aminehamed4twin7.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;

    @ManyToOne
    @JoinColumn(name = "idBloc") // Name of the foreign key column in the Chambre table
    private Bloc bloc;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idChambre") // Name of the foreign key column in the Reservation table
    private List<Reservation> reservations;
}
