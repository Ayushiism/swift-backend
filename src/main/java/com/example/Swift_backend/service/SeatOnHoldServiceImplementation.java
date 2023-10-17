package com.example.Swift_backend.service;

import com.example.Swift_backend.Dto.SeatOnHoldResponse;
import com.example.Swift_backend.SeatOnHoldTaskRunner;
import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.SeatOnHolds;
import com.example.Swift_backend.repository.SeatOnHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatOnHoldServiceImplementation implements SeatOnHoldService{

    @Autowired
    private SeatOnHoldRepository seatOnHoldRepository;


    @Override
    public SeatOnHoldResponse holdSeat(SeatOnHolds seatOnHolds) {


        SeatOnHoldResponse seatOnHoldResponse = new SeatOnHoldResponse();
        List<SeatOnHolds> listOfSeatsOnHold = seatOnHoldRepository.listOfHoldSeats(seatOnHolds.getSeat_id());
        boolean flag = false;
        for (SeatOnHolds seatOnHoldCurrent:listOfSeatsOnHold){
            if(seatOnHoldCurrent.getMovie_id()==seatOnHolds.getMovie_id() &&
                    seatOnHoldCurrent.getTheater_id()==seatOnHolds.getTheater_id() &&
                    seatOnHoldCurrent.getShow_id()== seatOnHolds.getShow_id()){
                flag = true;
                break;
            }
        }
        /**
         * if seat is not in hold
         */
        if(!flag){
            seatOnHoldRepository.save(seatOnHolds);
            SeatOnHoldTaskRunner seatOnHoldTaskRunner = new SeatOnHoldTaskRunner(seatOnHoldRepository , seatOnHolds);
            seatOnHoldTaskRunner.run();
            seatOnHoldResponse.seatBooked = true;
            return seatOnHoldResponse;
        }else{
            seatOnHoldResponse.seatBooked = false;
            return seatOnHoldResponse;
        }
    }



    @Override
    public SeatOnHolds removeSeat(long user_id) {
        SeatOnHolds seat = seatOnHoldRepository.findById(user_id).orElseThrow(() ->
                new ResourceNotFoundException("Seat not found for the user "+user_id));
        seatOnHoldRepository.delete(seat);
        return seat;
    }
}
