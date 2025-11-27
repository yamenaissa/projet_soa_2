package com.nadhem.Chansons.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.entities.Chanson;
@RepositoryRestResource(path = "rest")
public interface ChansonRepository extends JpaRepository<Chanson, Long> {
    List<Chanson> findByTitreChanson(String nom);

    List<Chanson> findByTitreChansonContains(String titre);


    @Query("select c from Chanson c where c.titreChanson like CONCAT('%',:nom, '%') and c.duree > :duree")
    List<Chanson> findByTitreDuree(@Param("nom") String nom, @Param("duree") Double duree);

    @Query("select c from Chanson c where c.album=:album")
    List<Chanson> findByAlbum(@Param("album") Album album);

    List<Chanson> findByAlbumIdAlb(Long id);

    List<Chanson> findByOrderByTitreChansonAsc();
    
    @Query("SELECT c FROM Chanson c ORDER BY c.titreChanson, c.duree")
    List<Chanson> trierChansonsTitreDuree();
}