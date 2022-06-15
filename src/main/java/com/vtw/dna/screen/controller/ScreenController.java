package com.vtw.dna.screen.controller;

import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.service.ScreenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/screen")
public class ScreenController {

    @Autowired private ScreenService screenService;

    @PostMapping("/selectAll")
    public List<Screen> selectAllScreen(){

        List<Screen> returnList = screenService.selectAllScreen();

        return null;

    }

    @PostMapping("/insert")
    public void insertScreen(Screen screen){

        screenService.insertScreen(screen);

    }

    @PostMapping("/calcfee")
    public void calcFee(Long screenSeq) throws ParseException {

        System.out.println("screenSeq!!!!!!! = " + screenSeq);

        Screen selectScreen = screenService.selectScreenByScreenSeq(screenSeq);

        selectScreen.setCalcFee();

        System.out.println(selectScreen.getBasicFee()+"!@#!@#!@#!@#"+selectScreen.getDiscountFee());


    }

}
