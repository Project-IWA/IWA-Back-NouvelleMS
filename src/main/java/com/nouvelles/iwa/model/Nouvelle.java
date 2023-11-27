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

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setAuteurId(String auteurId) {
        this.auteurId = auteurId;
    }

    // Constructors
    public Nouvelle() {
    }

    public Nouvelle(String id, String titre, String contenu, Date datePublication, String auteurId) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.auteurId = auteurId;
    }

    // toString, equals, hashCode methods if needed
}
