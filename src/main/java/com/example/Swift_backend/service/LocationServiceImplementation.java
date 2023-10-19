package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImplementation implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    public LocationServiceImplementation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        return optionalLocation.orElse(null);
    }



    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

}
