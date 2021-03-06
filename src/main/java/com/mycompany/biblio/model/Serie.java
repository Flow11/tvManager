/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */

@Entity
@NamedQuery(name = Serie.FIND_ALL, query = "SELECT s FROM Serie s")

public class Serie implements Serializable {
    public final static String FIND_ALL = "Serie.findAll";
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private String description;
    private double note;
    private Boolean selected;
    @OneToMany
    private List<Saison> saisons;
    
    public Serie() {
        
    }

    public Serie(String title, String description,String img, double note, Boolean selected) {
        this.title = title;
        this.description = description;
        this.note = note;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

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
     * @return the note
     */
    public double getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(double note) {
        this.note = note;
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

    public List<Saison> getSaisons() {
        return saisons;
    }

    public void addSaison(Saison saison) {
        saisons.add(saison);
    }
}
