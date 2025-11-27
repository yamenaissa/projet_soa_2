package com.nadhem.Chansons.entities;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Chanson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChanson;

    private String titreChanson;
    private Double duree; 
    private Date dateSortie;
    @ManyToOne
    private Album album;

    public Chanson() {
        super();
    }

    public Chanson(String titreChanson, Double duree, Date dateSortie) {
        super();
        this.titreChanson = titreChanson;
        this.duree = duree;
        this.dateSortie = dateSortie;
        
    }

    // Getters et Setters
    public Long getIdChanson() {
        return idChanson;
    }

    public void setIdChanson(Long idChanson) {
        this.idChanson = idChanson;
    }

    public String getTitreChanson() {
        return titreChanson;
    }

    public void setTitreChanson(String titreChanson) {
        this.titreChanson = titreChanson;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chanson [idChanson=" + idChanson + ", titreChanson=" + titreChanson +
                ", duree=" + duree + ", dateSortie=" + dateSortie + ", album=" + album + "]";
    }
}
