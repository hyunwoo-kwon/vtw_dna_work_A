package com.vtw.dna.reservation.service;

import com.vtw.dna.reservation.Reservation;
import com.vtw.dna.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation insertReservation(Reservation reservation){

        reservationRepository.save(reservation);

        return reservation;

    }

}
