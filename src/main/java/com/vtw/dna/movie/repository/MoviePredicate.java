package com.vtw.dna.movie.repository;

import com.vtw.dna.movie.Movie;

import java.util.List;

public interface MoviePredicate {
    
    /*검색*/
    public List<Movie> slectMovieList(Movie movie);
    
}
