package com.example.Swift_backend.service;

import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;

import java.util.List;

public interface ShowService {


    List<Show> getShowsByTheaterId(long id);
}
