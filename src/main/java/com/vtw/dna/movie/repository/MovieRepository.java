package com.vtw.dna.movie.repository;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.screen.ScreenRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Long> {


    Movie findByMovieSeq(Long movieSeq);

    Page<Movie> findAll(Pageable pageable);

}
