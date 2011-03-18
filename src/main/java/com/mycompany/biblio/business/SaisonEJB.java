package com.mycompany.biblio.business;

import com.mycompany.biblio.model.Saison;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;


@Stateless
public class SaisonEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Saison> findAll() {
        Query query = em.createNamedQuery(Saison.FIND_ALL);
        return query.getResultList();
    }

    public Saison create(Saison saison) {
        em.persist(saison);
        return saison;
    }

    public Saison update(Saison saison) {
        return em.merge(saison);
    }

    public void delete(List<Saison> list) {
        for (Saison saison : list) {
            delete(saison);
        }
    }

    public void delete(Saison saison) {
        em.remove(em.merge(saison));
    }
}
