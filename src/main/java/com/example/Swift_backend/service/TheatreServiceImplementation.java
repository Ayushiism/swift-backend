package com.example.Swift_backend.service;

import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.repository.LocationRepository;
import com.example.Swift_backend.repository.ShowRepository;
import com.example.Swift_backend.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImplementation implements TheatreService{

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Theatre getTheatreById(long id) {
        Optional<Theatre> optionalTheatre = theatreRepository.findById(id);
        return optionalTheatre.orElse(null);
    }


    @Override
    public List<Theatre> getTheatresByLocationId(long id) {

        try {
            return new ResponseEntity<List<Theatre>>(locationRepository.findTheatresByLocationId(id), HttpStatus.OK).getBody();
        }
        catch(Exception e){
            throw new ResourceNotFoundException("location does not exist");
        }
    }
}
