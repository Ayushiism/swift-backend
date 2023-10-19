package com.example.Swift_backend.service;

import com.example.Swift_backend.SeatOnHoldTaskRunner;
import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.repository.ActualShowRepository;
import com.example.Swift_backend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Swift_backend.Dto.SeatOnHoldResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActualShowImplementation implements ActualShowService{

    @Autowired
    private ActualShowRepository actualShowRepository;
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatOnHoldTaskRunner seatOnHoldTaskRunner;

    @Override
    public ActualShow checkAndCreateActualShow(long show_id, Date show_date){

        Show show = showRepository.getReferenceById(show_id);
        List<ActualShow> list = actualShowRepository.findByShowAndDate(show, show_date);
        ActualShow actualShow;

        if(list.isEmpty()){

            actualShow = new ActualShow();
            actualShow.setShow(show);
            actualShow.setDate(show_date);
            actualShow.setBooked_seats(new ArrayList<String>());
            actualShow.setHeld_seats(new ArrayList<String>());
            actualShowRepository.save(actualShow);
        }
        else{
            actualShow = list.get(0);
        }
        return actualShow;
    }


    @Override
    public SeatOnHoldResponse holdSeat(long id, List<String> seatsToBook) {
        SeatOnHoldResponse seatOnHoldResponse = new SeatOnHoldResponse();
        Optional<ActualShow> actualShow = actualShowRepository.findById(id);
            List<String> list;
            boolean flag = false;
            list = actualShow.orElseThrow(RuntimeException::new).getHeld_seats();
            for(int i = 0 ; i < list.size(); i++){
                for(int j = 0; j < seatsToBook.size(); j++){
                    if(seatsToBook.get(j) == list.get(i)){
                        flag = true;
                    }
                }

            }
        if(!flag){
            actualShow.get().setHeld_seats(seatsToBook);
            actualShowRepository.save(actualShow.get());
            seatOnHoldTaskRunner.run();
            ActualShow currentSeatOnHold = actualShowRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seat does not exit "+id));
            currentSeatOnHold.setHeld_seats(new ArrayList<>());
            actualShowRepository.save(currentSeatOnHold);
            seatOnHoldResponse.seatBooked = true;
            return seatOnHoldResponse;
        }else{
            seatOnHoldResponse.seatBooked = false;
            return seatOnHoldResponse;
        }
    }

    @Override
    public ActualShow updateSeat(boolean flag) {
        return null;
    }

    @Override
    public Boolean moveSeatFromHoldToBook(Boolean flag , long id) {
        ActualShow currentSeatOnHold = actualShowRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Seat does not exit "+id));
        List<String> bookedList = currentSeatOnHold.getBooked_seats();
        List<String> holdSeatList = currentSeatOnHold.getHeld_seats();
        bookedList.addAll(holdSeatList);
        currentSeatOnHold.setBooked_seats(bookedList);
        currentSeatOnHold.setHeld_seats(new ArrayList<>());
        actualShowRepository.save(currentSeatOnHold);
        seatOnHoldTaskRunner.terminateThread();
        return true;
    }


}


