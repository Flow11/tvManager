/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author root
 */
@Entity

public class Saison {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int numero;
}
