package com.nadhem.Chansons.service;

import java.util.List;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.entities.Chanson;

public interface ChansonService {

  Chanson saveChanson(Chanson c);

  Chanson updateChanson(Chanson c);

  void deleteChanson(Chanson c);

  void deleteChansonById(Long id);

  Chanson getChanson(Long id);

  List<Chanson> getAllChansons();

  List<Chanson> findByNom(String nom);

  List<Chanson> findByNomContaining(String nom);

  List<Chanson> findByTitreDuree(String nom, Double duree);

  List<Chanson> trierChansonsTitreDuree();

  List<Chanson> findByAlbum(Album album);

  List<Chanson> findByAlbumIdAlb(Long id);

  List<Chanson> findByOrderByTitreChansonAsc();

}
