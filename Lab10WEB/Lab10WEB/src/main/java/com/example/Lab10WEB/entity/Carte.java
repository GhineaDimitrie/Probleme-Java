package com.example.Lab10WEB.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carti")
public class Carte {

    @Id
    @Column(nullable = false)
    private String isbn;

    private String titlul;
    private String autorul;
}
