package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationServiceImplementation implements LocationService{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
