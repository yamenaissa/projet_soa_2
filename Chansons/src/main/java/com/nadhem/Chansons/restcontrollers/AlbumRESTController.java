package com.nadhem.Chansons.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.Chansons.entities.Album;
import com.nadhem.Chansons.repos.AlbumRepository;

@RestController
@RequestMapping("/api/alb")
@CrossOrigin(origins = "http://localhost:4200")
public class AlbumRESTController {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album getAlbumById(@PathVariable("id") Long id) {
        return albumRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Album createAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

}
