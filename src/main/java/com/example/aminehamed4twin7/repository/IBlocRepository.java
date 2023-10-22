package com.example.aminehamed4twin7.repository;

// IBlocRepository.java

import com.example.aminehamed4twin7.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc, Long> {
}

