package com.example.Swift_backend.service;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.model.Location;

import java.util.List;


public interface TheatreService {

    Theatre getTheatreById(long id);

    List<Theatre> getTheatresByLocationId(long id);

}
