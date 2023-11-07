package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.repository.IFoyerRepository;
import com.example.aminehamed4twin7.repository.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServicesImpl implements IUniversiteServices {

    final IFoyerRepository ifoyerRepository;

    @Autowired
    private IUniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }
    @Transactional
      @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer  = ifoyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        // return universiteRepository.save(universite);
        return universite;
        //save pour faire la mise a jour dans la base
    }
}
