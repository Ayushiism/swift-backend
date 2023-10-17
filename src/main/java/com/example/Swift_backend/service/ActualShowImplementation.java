package com.example.Swift_backend.service;

import com.example.Swift_backend.model.ActualShow;
import com.example.Swift_backend.model.Show;
import com.example.Swift_backend.repository.ActualShowRepository;
import com.example.Swift_backend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActualShowImplementation implements ActualShowService{

    @Autowired
    private ActualShowRepository actualShowRepository;
    @Autowired
    private ShowRepository showRepository;

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
}
