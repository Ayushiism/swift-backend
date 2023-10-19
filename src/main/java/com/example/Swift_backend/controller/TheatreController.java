package com.example.Swift_backend.controller;

import com.example.Swift_backend.Dto.TheatreDTO;
import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.service.LocationServiceImplementation;
import com.example.Swift_backend.service.TheatreServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/customer")
public class TheatreController {

    @Autowired
    private TheatreServiceImplementation theatreServiceImplementation;

    @Autowired
    private LocationServiceImplementation locationServiceImplementation;

    @PostMapping("/addTheatre")
    public ResponseEntity<Theatre> addTheatre(@RequestBody TheatreDTO theatreDTO) {
        // Create a new Theatre object
        Theatre theatre = new Theatre();
        theatre.setTheaterName(theatreDTO.getTheaterName());
        theatre.setTheaterAddress(theatreDTO.getTheaterAddress());

        // Try to find the corresponding Location
        Location location = locationServiceImplementation.getLocationById(theatreDTO.getLocationId());

        if (location == null) {
            // Handle invalid location ID (Location not found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Set the Location for the Theatre
        theatre.setLocation(location);

        // Save the Theatre to the database
        Theatre savedTheatre = theatreServiceImplementation.saveTheatre(theatre);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTheatre);
    }

    // Other methods for getting theatres by location, getting all theatres, etc.
}
