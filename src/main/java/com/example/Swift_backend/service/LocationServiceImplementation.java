package com.example.Swift_backend.service;

import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Theatre;
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
    public Location addTheatre(long id, Theatre theatre) {
        Location loc = locationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Location not Exit with id "+id));

        loc.getTheatre().add(theatre);
        return locationRepository.save(loc);
    }


    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

}
