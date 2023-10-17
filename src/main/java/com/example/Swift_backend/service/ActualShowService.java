package com.example.Swift_backend.service;

import com.example.Swift_backend.model.ActualShow;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface ActualShowService {

    ActualShow checkAndCreateActualShow(long show_id, Date show_date);
}
