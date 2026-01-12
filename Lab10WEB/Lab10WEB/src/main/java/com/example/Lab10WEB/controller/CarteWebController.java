package com.example.Lab10WEB.controller;

import com.example.Lab10WEB.entity.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Lab10WEB.repository.CarteRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarteWebController
{
    @Autowired
    CarteRepository repository;

    @PostMapping("/operatii")
    public String operatii(
            String isbn,
            String titlul,
            String autorul,
            String adauga,
            String modifica,
            String sterge,
            String filtreaza,
            Model model
    ) {
        String mesaj;

        /* ===================== ADAUGA ===================== */
        if (adauga != null) {

            if (isbn == null || isbn.isBlank()
                    || titlul == null || titlul.isBlank()
                    || autorul == null || autorul.isBlank()) {

                mesaj = "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!";

            } else if (repository.existsById(isbn)) {

                mesaj = "Există deja o carte cu ISBN-ul introdus!";

            } else {
                Carte c = new Carte();
                c.setIsbn(isbn);
                c.setTitlul(titlul);
                c.setAutorul(autorul);

                repository.save(c);
                mesaj = "Adaugare realizata cu succes!";
            }

            model.addAttribute("lista", repository.findAll());
        }

        /* ===================== MODIFICA ===================== */
        else if (modifica != null) {

            if (isbn == null || isbn.isBlank()
                    || !repository.existsById(isbn)) {

                mesaj = "Nu se gaseste nici o carte cu ISBN-ul introdus.";

            } else {
                Carte c = repository.findById(isbn).get();
                c.setTitlul(titlul);
                c.setAutorul(autorul);

                repository.save(c);
                mesaj = "Cartea cu ISBN-ul " + isbn + " a fost modificata!";
            }

            model.addAttribute("lista", repository.findAll());
        }

        /* ===================== STERGE ===================== */
        else if (sterge != null) {

            if (isbn == null || isbn.isBlank()
                    || !repository.existsById(isbn)) {

                mesaj = "Nu se gaseste nici o carte cu ISBN-ul introdus.";

            } else {
                repository.deleteById(isbn);
                mesaj = "Cartea cu ISBN-ul " + isbn + " a fost stearsa!";
            }

            model.addAttribute("lista", repository.findAll());
        }

        /* ===================== FILTREAZA ===================== */
        else if (filtreaza != null) {

            if (autorul == null || autorul.isBlank()) {
                mesaj = "Lista cartilor preluate prin repository";
                model.addAttribute("lista", repository.findAll());
            } else {
                mesaj = "Cartile urmatoare apartin autorului " + autorul;
                model.addAttribute("lista", repository.findByAutorul(autorul));
            }
        }

        /* ===================== CAZ IMPLICIT ===================== */
        else {
            mesaj = "Lista cartilor preluate prin repository";
            model.addAttribute("lista", repository.findAll());
        }

        model.addAttribute("str", mesaj);
        return "carti";
    }




    @GetMapping("/lista-carti")
    public String getListaCarti(Model model) {
        String s="Lista cartilor preluate prin repository";
        model.addAttribute("str",s);
        model.addAttribute("lista",repository.findAll());
        return "carti";
    }




}