package com.example.Swift_backend.controller;

import com.example.Swift_backend.Dto.BookedTicketResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @PostMapping("/paymentSuccess/{flag}")
    public BookedTicketResponse paymentSuccess(@PathVariable Boolean flag){
        BookedTicketResponse bookedTicketResponse = new BookedTicketResponse();
        if (flag){
            /**
             * update Booked seat
             */
            bookedTicketResponse.bookedTicket = true;
            return bookedTicketResponse;
        }else {
            /**
             * do nothing
             */
            bookedTicketResponse.bookedTicket = false;
            return bookedTicketResponse;
        }
    }
}
