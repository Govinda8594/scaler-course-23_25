package com.scaler.LLDProject.Bookmyshow.service;

import com.scaler.LLDProject.Bookmyshow.model.ShowSeat;
import com.scaler.LLDProject.Bookmyshow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId) {
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat) {
        return showSeatRepository.save(seat); // save() -> upsert, means insert and update both
    }
}
