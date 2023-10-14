package com.example.Swift_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Swift_backend.model.Location;
import com.example.Swift_backend.service.LocationServiceImplementation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("api/customer")
public class LocationController {

    @Autowired
    private LocationServiceImplementation locationServiceImplementation;

    @GetMapping("/locations")
    public Map<String, Object> getLocations() {

        Map<String, Object> response = new HashMap<String, Object>();

        response.put("userDetail", locationServiceImplementation.getAllLocations());
        return response;
    }


}
