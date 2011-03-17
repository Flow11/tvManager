/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author root
 */
@Entity
public class Saison implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int numero;
    @ManyToOne
    @JoinColumn(name="SERIE_ID")
    private Serie serie;
}
