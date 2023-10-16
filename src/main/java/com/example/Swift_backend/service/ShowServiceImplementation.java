package com.example.Swift_backend.service;

import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.repository.ShowRepository;
import com.example.Swift_backend.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ShowServiceImplementation implements ShowService{

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

//    @Override
//    public List<Show> getShowsByTheatre(Theatre theatre) {
//
//        if (theatre != null) {
//            return showRepository.findShowsByTheatre(theatre);
//        }
//        return null; // Handle the case where the theatre with the given ID doesn't exist
//    }
//
    public List<Show> getShowsByTheaterId(long id) {

        try {
            return new ResponseEntity<List<Show>>(theatreRepository.findShowsByTheatreId(id), HttpStatus.OK).getBody();
        }
        catch(Exception e){
            throw new ResourceNotFoundException("location does not exist");
        }
    }
}
