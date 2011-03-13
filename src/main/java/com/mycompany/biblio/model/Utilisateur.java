/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author root
 */

@Entity

public class Utilisateur {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String pseudo;
    @Column(nullable = false)
    private String password;
    private String avatar;
}
