package com.nouvelles.iwa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Nouvelle {

    @Id
    private String id;
    private String titre;
    private String contenu;
    private Date datePublication;
    private String auteurId;

    // Getters
    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public String getAuteurId() {
        return auteurId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Setters
    public void setDatePublication(Date datePublication) {
        if (datePublication == null) {
            this.datePublication = new Date(); // Date actuelle si aucune date n'est fournie
        } else {
            this.datePublication = datePublication;
        }
    }

    public void setAuteurId(String auteurId) {
        this.auteurId = auteurId;
    }

    // Constructors
    public Nouvelle() {
        this.datePublication = new Date(); // Initialise à la date actuelle
    }

    public Nouvelle(String id, String titre, String contenu, Date datePublication, String auteurId) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.datePublication = (datePublication != null) ? datePublication : new Date();
        this.auteurId = auteurId;
    }

    // toString, equals, hashCode methods if needed
}
