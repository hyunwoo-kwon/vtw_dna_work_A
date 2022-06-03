package com.vtw.dna.screen.repository;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.screen.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

}
