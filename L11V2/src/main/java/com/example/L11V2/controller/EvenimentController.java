package com.example.L11V2.controller;

import com.example.L11V2.entity.Eveniment;
import com.example.L11V2.repository.EvenimentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class EvenimentController {

    private final EvenimentRepository repository;

    public EvenimentController(EvenimentRepository repository) {
        this.repository = repository;
    }

    // GET - toate evenimentele
    @GetMapping("/eveniment")
    public List<Eveniment> getAllEvenimente() {
        return repository.findAll();
    }

    // GET - evenimente dupa locatie
    @GetMapping("/eveniment/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return repository.findByLocatie(locatie);
    }

    // GET - evenimente dupa data
    @GetMapping("/eveniment/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable LocalDate data) {
        return repository.findByData(data);
    }

    // POST - adaugare eveniment
    @PostMapping("/eveniment")
    public Eveniment addEveniment(@RequestBody Eveniment eveniment) {
        return repository.save(eveniment);
    }

    // PUT - modificare eveniment
    @PutMapping("/eveniment")
    public Eveniment updateEveniment(@RequestBody Eveniment eveniment) {
        return repository.save(eveniment);
    }

    // DELETE - stergere dupa id
    @DeleteMapping("/eveniment/id/{id}")
    public void deleteEveniment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
