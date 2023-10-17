package com.example.Swift_backend;

import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.SeatOnHolds;
import com.example.Swift_backend.repository.SeatOnHoldRepository;

public class SeatOnHoldTaskRunner implements Runnable{
    private SeatOnHoldRepository seatOnHoldRepository;
    private SeatOnHolds seatOnHolds;

    public SeatOnHoldTaskRunner(SeatOnHoldRepository seatOnHoldRepository , SeatOnHolds seatOnHolds){
        this.seatOnHoldRepository = seatOnHoldRepository;
        this.seatOnHolds = seatOnHolds;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();
        long end = start + 3000;

        while (System.currentTimeMillis() < end) {

        }

        SeatOnHolds currentSeatOnHold = seatOnHoldRepository.findById(seatOnHolds.getUser_id()).orElseThrow(() ->
                new ResourceNotFoundException("Seat does not exit "+seatOnHolds.getSeat_id()));
        seatOnHoldRepository.delete(currentSeatOnHold);
    }
}
