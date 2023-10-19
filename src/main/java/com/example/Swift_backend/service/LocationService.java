package com.example.Swift_backend.service;
import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Theatre;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();

    Location saveLocation(Location location);

    Location getLocationById(long id);

    Location addTheatre(long id, Theatre theatre);
}



