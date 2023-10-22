package com.example.aminehamed4twin7.repository;


import com.example.aminehamed4twin7.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {
}

