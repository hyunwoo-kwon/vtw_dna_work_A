package com.vtw.dna.movie.service;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository = null;

    public List<Movie> selectMovie(Movie movie){

        List<Movie> returnMovieList = new ArrayList<Movie>();


        return null;



    }

    public Movie insertMovie(Movie movie){

        movieRepository.save(movie);

        return movie;
    }



}
