package com.example.aminehamed4twin7.services;


import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.repository.IFoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoyerServicesImpl implements IFoyerServices {

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


}
