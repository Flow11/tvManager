package com.mycompany.biblio.business;

import com.mycompany.biblio.model.Serie;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;


@Stateless
public class SerieEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Serie> findAll() {
        Query query = em.createNamedQuery(Serie.FIND_ALL);
        return query.getResultList();
    }

    public Serie create(Serie serie) {
        em.persist(serie);
        return serie;
    }

    public Serie update(Serie serie) {
        return em.merge(serie);
    }

    public void delete(List<Serie> list) {
        for (Serie serie : list) {
            delete(serie);
        }
    }

    public void delete(Serie serie) {
        em.remove(em.merge(serie));
    }
}
