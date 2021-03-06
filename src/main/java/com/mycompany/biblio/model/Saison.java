/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author root
 */
@Entity
@NamedQuery(name = Saison.FIND_ALL, query = "SELECT s FROM Saison s")

public class Saison implements Serializable {
    public final static String FIND_ALL = "Saison.findAll";
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int numero;
    private Boolean selected;
    @OneToMany
    private List<Episode> episodes;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the epidodes
     */
    public List<Episode> getEpidodes() {
        return episodes;
    }

    /**
     * @param epidodes the epidodes to set
     */
    public void setEpidodes(List<Episode> epidodes) {
        this.episodes = epidodes;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public Boolean isSelected() {
        return selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
