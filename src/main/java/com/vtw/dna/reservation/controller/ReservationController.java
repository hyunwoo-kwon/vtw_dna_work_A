package com.vtw.dna.reservation.controller;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.reservation.Reservation;
import com.vtw.dna.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> list(){
        List<Reservation> reservationList = reservationRepository.findAll();
        System.out.println("test!@#$");
        if(reservationList.size()>0){
            for(Reservation one : reservationList){
                System.out.println(one);

            }
        }
        return reservationList;
    }


    @PostMapping("/insert")
    public void insertReservation(Reservation reservation){

        reservationRepository.save(reservation);

    }

}
