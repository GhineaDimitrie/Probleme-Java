package com.exemplu.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="masini")
public class Masina {
    @Id
    private String nr_inmatriculare;
    private String marca;
    private int anul;
    private String culoarea;
    private int km;

    public Masina() {
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public void setCuloarea(String culoarea) {
        this.culoarea = culoarea;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nr_inmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anul=" + anul +
                ", culoarea='" + culoarea + '\'' +
                ", km=" + km +
                '}';
    }
}
