package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    @Autowired private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> list(){
        List<Movie> movieList = movieRepository.findAll();
        System.out.println("test!@#$");
        if(movieList.size()>0){
            for(Movie one : movieList){
                System.out.println(one);

            }
        }
        return movieList;
    }
}
