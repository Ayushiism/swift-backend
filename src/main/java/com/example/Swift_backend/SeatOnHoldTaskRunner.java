package com.example.Swift_backend;

import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.repository.ActualShowRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class SeatOnHoldTaskRunner implements Runnable{

    private volatile boolean flag = false;
//    private ActualShowRepository actualShowRepository;
//    private ActualShow actualShow;

//    public SeatOnHoldTaskRunner(ActualShowRepository actualShowRepository , Optional<ActualShow> seatOnHolds){
//        this.actualShowRepository = actualShowRepository;
//        this.actualShow = actualShow;
//    }

//    @Override
    public void terminateThread(){
        flag = true;
    }
    @Override
    public void run() {

        long start = System.currentTimeMillis();
        long end = start + 3000;

        while (System.currentTimeMillis() < end && !flag) {

        }



//        ActualShow currentSeatOnHold = actualShowRepository.findById(actualShow.getId()).orElseThrow(() ->
//                new ResourceNotFoundException("Seat does not exit "+actualShow.getId()));
//        currentSeatOnHold.setHeld_seats(new ArrayList<>());
//        actualShowRepository.save(currentSeatOnHold);
    }
}
