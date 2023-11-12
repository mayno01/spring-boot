package com.example.aminehamed4twin7.Controllers;



import com.example.aminehamed4twin7.entities.Universite;
import com.example.aminehamed4twin7.services.IUniversiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversiteRestController {

    @Autowired
    private IUniversiteServices universiteServices;

    @GetMapping("/all")
    public List<Universite> retrieveAllUniversities() {
        return universiteServices.retrieveAllUniversities();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteServices.addUniversite(universite);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteServices.updateUniversite(universite);
    }

    @GetMapping("/{id}")
    public Universite retrieveUniversite(@PathVariable long id) {
        return universiteServices.retrieveUniversite(id);
    }



    @PutMapping("/lol/{idFoyer}/{nom}")
    public Universite affecterUnivFoyer(@PathVariable Long idFoyer, @PathVariable String nom) {
        return universiteServices.affecterFoyerAUniversite(idFoyer, nom);
    }

    @PutMapping("/des/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite ){
        return universiteServices.desaffecterFoyerAUniversite(idUniversite);
    }
}

