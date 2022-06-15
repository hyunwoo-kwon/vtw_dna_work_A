package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.movie.service.MovieService;
import com.vtw.dna.screen.ScreenRoom;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    @Autowired private MovieRepository movieRepository;
    @Autowired private MovieService movieService;

    @GetMapping
    public List<Movie> list(){
        List<Movie> movieList = movieRepository.findAll();
        System.out.println("test!@#$");
//        if(movieList.size()>0){
//            for(Movie one : movieList){
//                System.out.println(one);
//
//            }
//        }
        return null;
    }

    @GetMapping("/selectAll")
    public Page<Movie> selectAllScreenRoom(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam(value = "sortBy", defaultValue = "movieSeq") String sortBy,
                                                @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                                                @RequestParam(value = "filter", defaultValue = "") String filter){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));

        return movieService.selectAllMovei(pageable, filter);

    }

    @PostMapping("/insert")
    public void insertMovie(Movie movie){

        movieService.insertMovie(movie);

    }

    @GetMapping("/{movieSeq}")
    public Movie find(@PathVariable Long movieSeq) {
        Movie selectMoive = movieService.selectMovieByMovieSeq(movieSeq);
        return selectMoive;
    }
}
