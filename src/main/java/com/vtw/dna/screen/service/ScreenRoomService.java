package com.vtw.dna.screen.service;

import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.repository.ScreenRepository;
import com.vtw.dna.screen.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomService {

    @Autowired
    private ScreenRoomRepository screenRoomRepository = null;

    public ScreenRoom insertScreenRoom(ScreenRoom screenRoom){

        screenRoomRepository.save(screenRoom);

        return screenRoom;

    }

    public List<ScreenRoom> selectAllScreenRoom(){

        return screenRoomRepository.findAll();

    }

    public ScreenRoom selectScreenRoomByScreenRoomSeq(Long screenRoomSeq){

        return screenRoomRepository.findByScreenRoomSeq(screenRoomSeq);

    }

}
