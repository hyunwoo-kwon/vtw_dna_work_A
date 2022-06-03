package com.vtw.dna.reservation.repository;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
