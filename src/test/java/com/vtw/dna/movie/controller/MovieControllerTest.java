package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {

        Movie movie= new Movie("테스트","test","20200303","테스트 디테일입니다.");

        System.out.println("test123!!!!@@@@####");
        mockMvc.perform(post("/movie/insert").param("krName","테스트").param("enName","ennametest"));


        mockMvc.perform(get("/movie"));
    }
}