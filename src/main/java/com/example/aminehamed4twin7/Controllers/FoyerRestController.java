package com.example.aminehamed4twin7.Controllers;

import com.example.aminehamed4twin7.entities.Foyer;
import com.example.aminehamed4twin7.services.IFoyerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerRestController {

    @Autowired
    private IFoyerServices foyerServices;

    @GetMapping("/all")
    public List<Foyer> retrieveAllFoyers() {
        return foyerServices.retrieveAllFoyers();
    }

    @PostMapping("/add")
    public List<Foyer> addFoyers(@RequestBody List<Foyer> foyers) {
        return foyerServices.addFoyers(foyers);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.updateFoyer(foyer);
    }

    @GetMapping("/{id}")
    public Foyer retrieveFoyer(@PathVariable long id) {
        return foyerServices.retrieveFoyer(id);
    }

    @DeleteMapping("/{id}")
    public void removeFoyer(@PathVariable long id) {
        foyerServices.removeFoyer(id);
    }
}
