package com.scaler.LLDProject.Bookmyshow.repository;


import com.scaler.LLDProject.Bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
