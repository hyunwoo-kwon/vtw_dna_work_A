package com.vtw.dna.screen.service;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository = null;

    public Screen insertScreen(Screen screen){

        screenRepository.save(screen);

        return screen;

    }

    public List<Screen> selectAllScreen(){

        return screenRepository.findAll();

    }



    public Screen selectScreenByScreenSeq(Long screenSeq){

        return screenRepository.findByScreenSeq(screenSeq);

    }

}
