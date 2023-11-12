package com.example.aminehamed4twin7.services;

// BlocServicesImpl.java

import com.example.aminehamed4twin7.entities.Chambre;
import com.example.aminehamed4twin7.repository.IBlocRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aminehamed4twin7.entities.Bloc;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlocServicesImpl implements IBlocServices {

    @Autowired
    private IBlocRepository blocRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            // Create and associate Chambres with the Bloc
            List<Chambre> chambres = new ArrayList<>();
            for (Long numChambre : numeroChambre) {
                Chambre chambre = new Chambre();
                chambre.setNumeroChambre(numChambre);
                chambre.setBloc(bloc);
                chambres.add(chambre);
            }

            // Set the list of Chambres to the Bloc
            bloc.setChambres(chambres);

            // Save the updated Bloc
            blocRepository.save(bloc);
        }

        return bloc;
    }

}

