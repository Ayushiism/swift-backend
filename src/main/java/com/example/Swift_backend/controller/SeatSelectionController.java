package com.example.Swift_backend.controller;

import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.model.SeatType;
import com.example.Swift_backend.repository.SeatTypeRepository;
import com.example.Swift_backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;


@RestController
@CrossOrigin("*")
@RequestMapping("seat-selection")
public class SeatSelectionController {

    @Autowired
    private ActualShowImplementation actualShowImplementation;
    @Autowired
    private SeatTypeImplementation seatTypeImplementation;
    @Autowired
    private RatingImplementation ratingImplementation;

    @PostMapping
    public Map<String, Object> dataForSeatSelection(@RequestBody Map<String, String> request) {

        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> prices = new HashMap<String, Object>();

        ActualShow actualShow = actualShowImplementation.checkAndCreateActualShow(Long.parseLong(request.get("seat_id")) , new Date(request.get("date")));
        List<SeatType> seatType = seatTypeImplementation.getAllSeatTypes();

        Date today = new Date();
        Date releaseDate = actualShow.getShow().getMovie().getRelease_date();

        boolean isCheap =  (today.getHours()==8);

        for(SeatType st: seatType){
            prices.put(st.getName(), isCheap ? st.getLowerPrice() : st.getOriginalPrice());
        }


        boolean reclinerBlock = false;
        boolean checkTime = false;


        long difference_In_Time = today.getTime() - releaseDate.getTime();
        long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
        long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;

        if(actualShow.getShow().getMovie().getIsBlockbuster()){

            if(today.before(releaseDate)){
                reclinerBlock = true;
            }
            else if(difference_In_Days<=3){
                checkTime = true;
            }
            else if(difference_In_Days<=14){
                if(actualShow.getShow().getMovie().getRating().getConsolidatedRating() == null){
                    ratingImplementation.updateConsolidatedRating(actualShow.getShow().getMovie().getRating());
                }

                if(actualShow.getShow().getMovie().getRating().getConsolidatedRating()>=4){
                    checkTime = true;
                }
            }
        }

        if(checkTime){
            if(difference_In_Hours>2){
                reclinerBlock =true;
            }
        }

        if(reclinerBlock){

            for(SeatType st: seatType){
                if(st.getName().equals("recliner")) {
                    prices.put(st.getName(), st.getHigherPrice());
                }
            }

            List<String> reclinerSeats = new ArrayList<String>();
            for(int i = 1; i<=10; i++){
                reclinerSeats.add("J" + i);
            }
           actualShow.getBooked_seats().addAll(reclinerSeats);
        }

        response.put("actualShow", actualShow);
        response.put("prices", prices);

        return response;
    }
}
