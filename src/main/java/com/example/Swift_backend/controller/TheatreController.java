package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.model.Theatre;
import com.example.Swift_backend.repository.LocationRepository;
import com.example.Swift_backend.service.LocationServiceImplementation;
import com.example.Swift_backend.service.TheatreServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/customer")
public class TheatreController {
    @Autowired
    private TheatreServiceImplementation theatreServiceImplementation;

    @Autowired
    private LocationServiceImplementation locationServiceImplementation;


    @GetMapping("/theatres/{id}")
    public Map<String, Object> getTheatresByLocation(@PathVariable long id) {
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            List<Theatre> theatres = theatreServiceImplementation.getTheatresByLocationId(id);
            response.put("theatres", theatres);
            return response;
        }
        catch (Error e){
            response.put("error", true);
            response.put("msg", "location id is wrong");
            return response;
        }
    }


}
