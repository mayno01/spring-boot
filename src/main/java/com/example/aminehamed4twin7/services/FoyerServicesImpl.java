package com.example.aminehamed4twin7.services;


import com.example.aminehamed4twin7.entities.Bloc;
import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.repository.IFoyerRepository;
import com.example.aminehamed4twin7.repository.IUniversiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoyerServicesImpl implements IFoyerServices {

    @Autowired
    private IUniversiteRepository universiteRepository;

    @Autowired
    private IFoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Transactional
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null && foyer != null) {
            // Set the Foyer to the specified Universite
            universite.setFoyer(foyer);

            // Check the capacity of the Foyer
            long capaciteFoyer = foyer.getCapaciteFoyer();
            int numberOfBlocks = (int) Math.ceil((double) capaciteFoyer / 10);

            // Create Blocs with capacities based on the Foyer's capacity
            List<Bloc> blocs = new ArrayList<>();
            for (int i = 0; i < numberOfBlocks; i++) {
                long blocCapacity = Math.min(10, capaciteFoyer);
                capaciteFoyer -= blocCapacity;

                Bloc bloc = new Bloc();
                bloc.setNomBloc("Bloc " + (i + 1));
                bloc.setCapaciteBloc(blocCapacity);
                bloc.setFoyer(foyer);

                blocs.add(bloc);
            }

            // Set the list of Blocs to the Foyer
            foyer.setBlocs(blocs);

            // Save the Foyer along with associated Blocs
            foyerRepository.save(foyer);
        }

        return foyer;
    }



}
