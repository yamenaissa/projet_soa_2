package com.nadhem.Chansons.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "titreChan", types = { Chanson.class })
public interface ChansonProjection {
    public String getTitreChanson();
}