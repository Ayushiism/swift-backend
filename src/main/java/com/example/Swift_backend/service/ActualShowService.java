package com.example.Swift_backend.service;

import com.example.Swift_backend.model.ActualShow;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.example.Swift_backend.Dto.SeatOnHoldResponse;


public interface ActualShowService {

    ActualShow checkAndCreateActualShow(long show_id, Date show_date);

    SeatOnHoldResponse holdSeat(long id, List<String> seatsToBook);

    ActualShow updateSeat(boolean flag);

    Boolean moveSeatFromHoldToBook(Boolean flag , long id);
}
