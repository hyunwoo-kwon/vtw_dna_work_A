package com.vtw.dna.screen.controller;

import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.service.ScreenRoomService;
import com.vtw.dna.screen.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/screenRoom")
public class ScreenRoomController {

    @Autowired private ScreenRoomService screenRoomService;

    @PostMapping("/selectAll")
    public List<ScreenRoom> selectAllScreenRoom(){

        List<ScreenRoom> returnList = screenRoomService.selectAllScreenRoom();
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        if(returnList.size()>0){
//            for(Screen one : returnList){
//                System.out.println(one);
//            }
//        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        return null;

    }

    @PostMapping("/insert")
    public void insertScreenRoom(ScreenRoom screenRoom){

        screenRoomService.insertScreenRoom(screenRoom);

    }

}
