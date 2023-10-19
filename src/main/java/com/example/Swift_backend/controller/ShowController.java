package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Movie;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.service.ShowServiceImplementation;
import com.example.Swift_backend.service.TheatreServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/customer")
public class ShowController {

    @Autowired
    private TheatreServiceImplementation theatreServiceImplementation;

    @Autowired
    private ShowServiceImplementation showServiceImplementation;

//    @GetMapping("/shows/{id}")
//    public Map<String, Object> getShowsByTheatreId(@PathVariable long id) {
//        Theatre theatre = theatreServiceImplementation.getTheatreById(id);
//        Map<String, Object> response = new HashMap<String, Object>();
//        if (theatre == null) {
//            // Handle the case where the location with the given ID doesn't exist
//            // You can return an error message or appropriate HTTP status code (e.g., 404 Not Found)
//            //return null;
//            response.put("error", true);
//            response.put("msg", "username already exists");
//            return response;
//        } else {
//            List<Show> shows = showServiceImplementation.getShowsByTheatre(theatre);
//            // Create a map to hold the response data
//            response.put("error", false);
//            response.put("msg", "username already exists");
//            response = Map.of(
//                    "theatre", theatre,
//                    "theatreId", id,
//                    "shows", shows
//            );
//            // Return the response
//            return response;
//        }


    @GetMapping("/show/{id}")
    public Map<String, Object> getShowsByTheatre(@PathVariable long id) {
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            List<Show> shows = showServiceImplementation.getShowsByTheaterId(id);
            response.put("shows", shows);
            return response;
        }
        catch (Error e){
            response.put("error", true);
            response.put("msg", "theatre id is wrong");
            return response;
        }
    }

    @PostMapping("/addShow")
    public ResponseEntity<Show> addShow(@RequestBody Show show) {
        Show savedShow = showServiceImplementation.saveShow(show);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShow);
    }


}
