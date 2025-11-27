package com.nadhem.Chansons.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nadhem.Chansons.entities.Chanson;
import com.nadhem.Chansons.service.ChansonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // allows access from Postman / frontend
public class ChansonRESTController {

    @Autowired
    private ChansonService chansonService;

    // ✅ 1. Get all chansons
    @GetMapping("/all")
    List<Chanson> getAllChansons() {
        return chansonService.getAllChansons();
    }

    // ✅ 2. Get chanson by ID
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Chanson getChansonById(@PathVariable("id") Long id) {
        return chansonService.getChanson(id);
    }

    // ✅ 3. Create new chanson
    @RequestMapping(path = "/addchans", method = RequestMethod.POST)
    public Chanson createChanson(@RequestBody Chanson chanson) {
        return chansonService.saveChanson(chanson);
    }

    // ✅ 4. Update existing chanson
    @RequestMapping(path = "/updatechans", method = RequestMethod.PUT)
    public Chanson updateChanson(@RequestBody Chanson chanson) {
        return chansonService.updateChanson(chanson);
    }

    // ✅ 5. Delete chanson by ID
    @RequestMapping(value = "/delchans/{id}", method = RequestMethod.DELETE)
    public void deleteChanson(@PathVariable("id") Long id) {
        chansonService.deleteChansonById(id);
    }

    // ✅ 6. Get chansons by album
    @RequestMapping(value = "/chansAlb/{idAlb}", method = RequestMethod.GET)
    public List<Chanson> getChansonsByCatId(@PathVariable("idAlb") Long idAlb) {
        return chansonService.findByAlbumIdAlb(idAlb);
    }

    // ✅ 7. Get chansons by name containing
    @RequestMapping(value = "/chansByName/{nom}", method = RequestMethod.GET)
    public List<Chanson> findByNomContaining(@PathVariable("nom") String nom) {
        return chansonService.findByNomContaining(nom);
    }

}
