package com.example.Swift_backend.controller;

import com.example.Swift_backend.Dto.SeatOnHoldResponse;
import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.service.ActualShowImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/seatOnHold")
public class SeatOnHoldController {

    @Autowired
    private ActualShowImplementation actualShowImplementation;

    @PostMapping("/holdSeat")
    public SeatOnHoldResponse holdSeatForBooking(@RequestBody long id, List<String> seatsToHold){
        return actualShowImplementation.holdSeat(id,seatsToHold);
    }


}
