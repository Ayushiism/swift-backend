package com.example.Swift_backend.controller;

import com.example.Swift_backend.Dto.BookedTicketResponse;
import com.example.Swift_backend.exception.ResourceNotFoundException;
import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.repository.ActualShowRepository;
import com.example.Swift_backend.service.ActualShowImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private ActualShowImplementation actualShowImplementation;
    @PostMapping("/paymentSuccess/")
    public BookedTicketResponse paymentSuccess(@RequestBody BookedTicketResponse bookedTicketResponse){



        if (bookedTicketResponse.flag){
            /**
             * update Booked seat
             */

            actualShowImplementation.moveSeatFromHoldToBook(bookedTicketResponse.flag , bookedTicketResponse.id);
            bookedTicketResponse.flag = true;
            return bookedTicketResponse;
        }else {
            /**
             * do nothing
             */
            bookedTicketResponse.flag = false;
            return bookedTicketResponse;
        }
    }
}
