package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.service.ActualShowImplementation;
import com.example.Swift_backend.service.ActualShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("seat-selection")
public class SeatSelectionController {

    @Autowired
    private ActualShowImplementation actualShowImplementation;

    @PostMapping
    public Map<String, Object> dataForSeatSelection(@RequestBody Map<String, String> request) {

        Map<String, Object> response = new HashMap<String, Object>();

        ActualShow actualShow = actualShowImplementation.checkAndCreateActualShow(Long.parseLong(request.get("seat_id")) , new Date(request.get("date")));

        if(actualShow.getShow().getMovie().getIsBlockbuster()){

            Date today = new Date();
            //if(today)
        }
        response.put("actualShow", actualShow);


        return response;
    }
}
