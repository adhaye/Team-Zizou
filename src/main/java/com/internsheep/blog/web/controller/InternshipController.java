package com.internsheep.blog.web.controller;

import com.internsheep.blog.Model.Internship;
import com.internsheep.blog.dao.InternshipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.net.URI;
import java.util.List;

@RestController
public class InternshipController {

    @Autowired
    private InternshipDao internshipDao;

    /*@RequestMapping ( value="/description" , method= RequestMethod.GET)
    public List<Internship> listInternships(){
        return internshipDao.findAll();
    }*/
    @RequestMapping ( value="/description" , method= RequestMethod.GET)
    public MappingJacksonValue listeProduits() {
        List<Internship> produits = internshipDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("tel");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    /*@PostMapping(value = "/stage")
    public void ajouterProduit(@RequestBody Internship internship) {
        internshipDao.save(internship);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(internshipAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }*/

    @PostMapping(value = "/stage")

    public ResponseEntity<Void> ajouterProduit(@RequestBody Internship product) {
        Internship productAdded =  internshipDao.save(product);
        if (productAdded == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping (value = "/description/{id}")
    public Internship afficherUnInternship(@PathVariable int id) {

        return internshipDao.findById(id);
    }

}
