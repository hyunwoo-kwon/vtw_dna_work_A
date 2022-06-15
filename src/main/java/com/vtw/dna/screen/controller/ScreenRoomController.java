package com.vtw.dna.screen.controller;

import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.ScreenRoomSeat;
import com.vtw.dna.screen.form.ScreenRoomForm;
import com.vtw.dna.screen.service.ScreenRoomSeatService;
import com.vtw.dna.screen.service.ScreenRoomService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/screenRoom")
public class ScreenRoomController {

    @Autowired private ScreenRoomService screenRoomService;
    @Autowired private ScreenRoomSeatService screenRoomSeatService;

    @Autowired private ModelMapper modelMapper;

    @GetMapping("/selectAll")
    public Page<ScreenRoom> selectAllScreenRoom(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam(value = "sortBy", defaultValue = "screenRoomSeq") String sortBy,
                                                @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                                                @RequestParam(value = "filter", defaultValue = "") String filter){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));

        return screenRoomService.selectAllScreenRoom(pageable, filter);

    }

    @PostMapping("/insert")
    public void insertScreenRoom(@RequestBody ScreenRoom screenRoom){

        ScreenRoom insertScreenRoom = screenRoomService.insertScreenRoom(screenRoom);

        screenRoomSeatService.insertScreenRoomSeat(insertScreenRoom.getScreenRoomSeq());


    }

    @GetMapping("/{screenRoomSeq}")
    public ScreenRoomForm.Resonse find(@PathVariable Long screenRoomSeq) {
        ScreenRoom selectscreenRoom = screenRoomService.selectScreenRoomByScreenRoomSeq(screenRoomSeq);

        if(selectscreenRoom.getScreenRoomSeatList()!=null){

            System.out.println("returnData.getScreenRoomSeatListSeatLow() != null");

            for (ScreenRoomSeat one : selectscreenRoom.getScreenRoomSeatList()){
                System.out.println("!!data = " + one.getSeatRow() + " "+ one.getSeatColumn());
            }

        }

        ScreenRoomForm.Resonse returnData = modelMapper.map(selectscreenRoom, ScreenRoomForm.Resonse.class);

        System.out.println("!!@@@###$$$ test");
        if(returnData.getScreenRoomSeatList()!=null){

            System.out.println("returnData.getScreenRoomSeatListSeatLow() != null");

            for (ScreenRoomSeat one : returnData.getScreenRoomSeatList()){
                System.out.println("!!data = " + one.getSeatRow() + " "+ one.getSeatColumn());
            }

        }


        System.out.println("!!@@@###$$$ test2");
        if(returnData.getScreenRoomSeatListSeatLow()!=null){

            System.out.println("returnData.getScreenRoomSeatListSeatLow() != null");

            for (String one : returnData.getScreenRoomSeatListSeatLow()){
                System.out.println("!!data = " + one);
            }

        }

        System.out.println("!!@@@###$$$ test3");
        List<ScreenRoomForm.ResonseList> returnDataList = modelMapper.map(selectscreenRoom.getScreenRoomSeatList(),
                                                                    new TypeToken<List<ScreenRoomForm.ResonseList>>(){}.getType());

        if (returnDataList != null){
            for(ScreenRoomForm.ResonseList one : returnDataList){
                System.out.println("!!data = " + one.getSeatRow() + " "+ one.getSeatColumn());
            }
        }

        return returnData;
    }

}
