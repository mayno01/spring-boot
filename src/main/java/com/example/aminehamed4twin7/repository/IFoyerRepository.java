package com.example.aminehamed4twin7.repository;

import com.example.aminehamed4twin7.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
}