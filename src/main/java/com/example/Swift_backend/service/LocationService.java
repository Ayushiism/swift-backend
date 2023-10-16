package com.example.Swift_backend.service;
import com.example.Swift_backend.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();

    Location getLocationById(long id);
}



