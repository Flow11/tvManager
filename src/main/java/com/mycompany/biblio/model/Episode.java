/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author root
 */
@Entity
@NamedQuery(name = Episode.FIND_ALL, query = "SELECT e FROM Episode e")

public class Episode implements Serializable {
    public final static String FIND_ALL = "Episode.findAll";
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private String description;
    private int numero;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDiffusion;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the dateDiffusion
     */
    public Date getDateDiffusion() {
        return dateDiffusion;
    }

    /**
     * @param dateDiffusion the dateDiffusion to set
     */
    public void setDateDiffusion(Date dateDiffusion) {
        this.dateDiffusion = dateDiffusion;
    }
}