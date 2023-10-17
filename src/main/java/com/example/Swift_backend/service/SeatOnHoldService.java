package com.example.Swift_backend.service;


import com.example.Swift_backend.Dto.SeatOnHoldResponse;
import com.example.Swift_backend.model.SeatOnHolds;

public interface SeatOnHoldService {

    SeatOnHoldResponse holdSeat(SeatOnHolds seatOnHolds);

    SeatOnHolds removeSeat(long user_id);
}
