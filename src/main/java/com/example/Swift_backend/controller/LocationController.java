package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.service.LocationServiceImplementation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    private LocationServiceImplementation locationServiceImplementation;

    @GetMapping("/locations")
    public Map<String, Object> getLocations() {

        Map<String, Object> response = new HashMap<String, Object>();

        response.put("locationDetails", locationServiceImplementation.getAllLocations());
        return response;
    }

    @PostMapping("/addLocation")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location savedLocation = locationServiceImplementation.saveLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }
    @PostMapping("/addTheatre/{id}")
    public ResponseEntity<Location> addTheatre(@PathVariable long id, @RequestBody Theatre theatre){
        Location addtheatre = locationServiceImplementation.addTheatre(id, theatre);
        return  ResponseEntity.status(HttpStatus.CREATED).body(addtheatre);

    }


}
