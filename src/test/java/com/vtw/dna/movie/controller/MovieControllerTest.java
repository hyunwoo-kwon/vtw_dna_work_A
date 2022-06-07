package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {

        List<Movie> movieList = new ArrayList<Movie>();

        Movie movie= new Movie("테스트","test","20200303","테스트 디테일입니다.");

        for(int i = 0 ; i <10 ; i++){

            mockMvc.perform(post("/movie/insert").param("krName","테스트"+i)
                                                            .param("enName","enNameTest"+i)
                                                            .param("releaseDate","enNameTest"+i)
                                                            .param("detail","enNameTest"+i));

        }

        mockMvc.perform(get("/movie"));
    }
}