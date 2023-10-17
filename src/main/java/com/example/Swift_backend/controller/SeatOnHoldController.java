package com.example.Swift_backend.controller;

import com.example.Swift_backend.Dto.SeatOnHoldResponse;
import com.example.Swift_backend.model.SeatOnHolds;
import com.example.Swift_backend.service.SeatOnHoldServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/seatOnHold")
public class SeatOnHoldController {

    @Autowired
    private SeatOnHoldServiceImplementation seatOnHoldServiceImplementation;

    @PostMapping("/holdSeat")
    public SeatOnHoldResponse holdSeatForBooking(@RequestBody SeatOnHolds seatOnHolds){
        return seatOnHoldServiceImplementation.holdSeat(seatOnHolds);
    }


}
