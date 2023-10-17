package com.example.Swift_backend.service;

import com.example.Swift_backend.model.SeatType;
import com.example.Swift_backend.repository.SeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatTypeImplementation implements SeatTypeService{

    private SeatTypeRepository seatTypeRepository;
    @Override
    public List<SeatType> getAllSeatTypes(){
        return seatTypeRepository.findAll();
    }
}
