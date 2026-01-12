package com.example.Lab10WEB.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Lab10WEB.entity.Carte;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte,String>{
    List<Carte> findByAutorul(String autorul);}
