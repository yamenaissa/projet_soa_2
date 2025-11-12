package com.nadhem.Chansons.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlb;
    private String nomAlb;
    private String descriptionAlb;
    @JsonIgnore
    @OneToMany(mappedBy = "album")
    private List<Chanson> chansons;
    
    
    public Album() {
        super();
    }   

    public List<Chanson> getChansons() {
        return chansons;
    }

    public void setChansons(List<Chanson> chansons) {
        this.chansons = chansons;
    }

    public Long getIdAlb() {
        return idAlb;
    }

    public void setIdAlb(Long idAlb) {
        this.idAlb = idAlb;
    }

    public String getNomAlb() {
        return nomAlb;
    }

    public void setNomAlb(String nomAlb) {
        this.nomAlb = nomAlb;
    }

    public String getDescriptionAlb() {
        return descriptionAlb;
    }

    public void setDescriptionAlb(String descriptionAlb) {
        this.descriptionAlb = descriptionAlb;
    }

}
