package com.vtw.dna.screen.controller;

import com.vtw.dna.screen.ScreenRoomSeat;
import com.vtw.dna.screen.service.ScreenRoomSeatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/screenRoomSeat")
public class ScreenRoomSeatController {

    @Autowired private ScreenRoomSeatService screenRoomSeatService;

    @PostMapping("/fullSeat")
    public List<ScreenRoomSeat> selectFullSeat(Long screenRoomSeq){

        List<ScreenRoomSeat> returnList = screenRoomSeatService.selectScreenRoomSeatByscreenRoomSeq(screenRoomSeq);

        String tempLow = "0";

        for(ScreenRoomSeat one : returnList){
            if(tempLow!=one.getSeatLow()){
                System.out.println("");
                tempLow = one.getSeatLow();
            }

            if(one.getUseYn().equals("Y")) System.out.printf("□ ");
            if(one.getUseYn().equals("N")) System.out.printf("■ ");

        }


//        Stream<ScreenRoomSeat> list = returnList.stream();
//
//        list.forEach(e-> System.out.println(e));

        return null;

    }

    @PostMapping("/insert")
    public void insertScreenRoomSeat(Long screenRoomSeq){

        screenRoomSeatService.insertScreenRoomSeat(screenRoomSeq);

    }

    @PostMapping("/update")
    public void updateScreenRoomSeat(Long screenRoomSeq, String seatLow, Integer seatColumn, String useYn){

        screenRoomSeatService.updateScreenRoomSeatByScreenRomSeqAndLowAndColumn(screenRoomSeq, seatLow, seatColumn, useYn);

    }

}
