package com.mycompany.biblio.business;

import com.mycompany.biblio.model.Episode;
import com.mycompany.biblio.model.Saison;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;


@Stateless
public class EpisodeEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Episode> findAll() {
        Query query = em.createNamedQuery(Episode.FIND_ALL);
        return query.getResultList();
    }

    public List<Episode> findNextEp() {
        Query q = em.createQuery ("Select s FROM Episode s WHERE s.dateDiffusion > :today");
        q.setParameter ("today", new Date());
        return q.getResultList();
    }

    public Episode create(Episode episode,Long id) {

        Saison saison = em.find(Saison.class, id);
        saison.addEpisode(episode);
        em.persist(episode);
        em.persist(saison);
        
        return episode;
    }

    public Episode update(Episode episode) {
        return em.merge(episode);
    }

    public void delete(List<Episode> list) {
        for (Episode episode : list) {
            delete(episode);
        }
    }

    public void delete(Episode episode) {
        em.remove(em.merge(episode));
    }
}
