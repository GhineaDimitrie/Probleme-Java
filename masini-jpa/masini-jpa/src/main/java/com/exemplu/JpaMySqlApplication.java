package com.exemplu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exemplu.entity.Masina;
import com.exemplu.repository.MasinaJpaRepository;

import java.sql.SQLOutput;

@SpringBootApplication
public class JpaMySqlApplication implements CommandLineRunner {

    @Autowired
    MasinaJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JpaMySqlApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("------- JPA -------");

        System.out.println("\nContinutul initial al tabelei masini:");
        repository.findAll().forEach(System.out::println);

        System.out.println("\nMasina cu numarul de inmatriculare MH25DMI:");
        System.out.println(repository.findByNrInmatriculare("MH25DMI"));

        System.out.println("\nSe sterge masina cu numarul de inmatriculare MH25DMI");
        repository.deleteByNrInmatriculare("MH25DMI");
        System.out.println("\nContinutul de dupa stergere al tabelei masini:");
        repository.findAll().forEach(System.out::println);

        Masina m = new Masina();
        m.setNr_inmatriculare("TM01AAA");
        m.setMarca("Dacia");
        m.setAnul(2021);
        m.setCuloarea("alb");
        m.setKm(45000);


        System.out.println("\nSe adauga masina:");
        System.out.println(repository.insert(m));

        System.out.println("\nContinutul de dupa adaugare in tabela masini:");
        repository.findAll().forEach(System.out::println);

        System.out.println("Nr masinilor cu  marca masinilor cautata este:"+repository.countByMarca("Renault"));
        System.out.println("Nr masini cu km putini:"+repository.countByKm());

        System.out.println("Masini mai noi de 5 ani:"+repository.MasiniNoi());





    }
}
