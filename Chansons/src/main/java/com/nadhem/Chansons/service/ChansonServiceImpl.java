package com.nadhem.Chansons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.entities.Chanson;
import com.nadhem.Chansons.repos.ChansonRepository;

@Service
public class ChansonServiceImpl implements ChansonService {
    @Autowired
    ChansonRepository chansonRepository;

    @Override
    public Chanson saveChanson(Chanson c) {
        return chansonRepository.save(c);
    }

    @Override
    public Chanson updateChanson(Chanson c) {
        return chansonRepository.save(c);
    }

    @Override
    public void deleteChanson(Chanson c) {
        chansonRepository.delete(c);

    }

    @Override
    public void deleteChansonById(Long id) {
        chansonRepository.deleteById(id);

    }

    @Override
    public Chanson getChanson(Long id) {
        return chansonRepository.findById(id).get();

    }

    @Override
    public List<Chanson> getAllChansons() {
        return chansonRepository.findAll();
    }

    @Override
    public List<Chanson> findByNom(String nom) {
        return chansonRepository.findByTitreChanson(nom);
    }

    @Override
    public List<Chanson> findByNomContaining(String nom) {
        return chansonRepository.findByTitreChansonContains(nom);
    }

    @Override
    public List<Chanson> findByTitreDuree(String nom, Double duree) {
        return chansonRepository.findByTitreDuree(nom, duree);
    }

    @Override
    public List<Chanson> findByAlbum(Album album) {
        return chansonRepository.findByAlbum(album);
    }

    public List<Chanson> findByAlbumIdAlb(Long id) {
        return chansonRepository.findByAlbumIdAlb(id);
    }

    public List<Chanson> findByOrderByTitreChansonAsc() {
        return chansonRepository.findByOrderByTitreChansonAsc();
    }

    @Override
    public List<Chanson> trierChansonsTitreDuree() {
        return chansonRepository.trierChansonsTitreDuree();
    }

}
