package com.exemplu.repository;

import java.util.List;
import com.exemplu.entity.Masina;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MasinaJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Masina> findAll(){
        TypedQuery<Masina> query=entityManager.createQuery("from Masina",Masina.class);
        return query.getResultList();
    }
    public Masina findByNrInmatriculare(String  nr_inmatriculare){
        return entityManager.find(Masina.class, nr_inmatriculare);
    }
    public void deleteByNrInmatriculare(String nrInmatriculare) {
        Masina masina = findByNrInmatriculare(nrInmatriculare);
        if (masina != null) {
            entityManager.remove(masina);
        } else {
            System.out.println("Nu exista masina cu nr " + nrInmatriculare);
        }
    }

    public Masina insert(Masina masina){
        return entityManager.merge(masina);
    }
    public Masina update(Masina masina){
        return entityManager.merge(masina);
    }


    public long  countByMarca(String marca)
    {
        TypedQuery<Long> query= entityManager.createQuery("SELECT COUNT(m) FROM Masina m WHERE m.marca=:marca",Long.class);
        query.setParameter("marca",marca);
        return query.getSingleResult();

    }

    public long  countByKm()
    {
        TypedQuery<Long> query= entityManager.createQuery("SELECT COUNT(m) FROM Masina m WHERE m.km<100000",Long.class);

        return query.getSingleResult();

    }



    public List<Masina> MasiniNoi(){
        TypedQuery<Masina> query=entityManager.createQuery("SELECT m FROM Masina m WHERE m.anul>2021",Masina.class);
        return query.getResultList();
    }



}