package com.vtw.dna.screen.controller;

import com.vtw.dna.screen.Screen;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/screen")
public class ScreenController {

    @PostMapping("/insert")
    public void insertScreen(Screen screen){


    }

}
