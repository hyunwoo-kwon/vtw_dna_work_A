package com.vtw.dna.sample;

import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.ScreenRoomSeat;
import com.vtw.dna.screen.repository.ScreenRepository;
import com.vtw.dna.screen.repository.ScreenRoomRepository;
import com.vtw.dna.screen.service.ScreenRoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenRoomInitializer implements SampleDataInitializer{

    private final ScreenRoomRepository repository;

    @Autowired private ScreenRoomSeatService screenRoomSeatService;


    public ScreenRoomInitializer(ScreenRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateData() {

        ScreenRoom screenRoom1 = new ScreenRoom("E",6);
        ScreenRoom screenRoom2 = new ScreenRoom("C",6);
        ScreenRoom screenRoom3 = new ScreenRoom("B",6);

        create(screenRoom1);
        create(screenRoom2);
        create(screenRoom3);

    }

    private void create(ScreenRoom screenRoom){
        repository.save(screenRoom);
        System.out.println("!@#!@#!@#");
        screenRoomSeatService.insertScreenRoomSeat(screenRoom.getScreenRoomSeq());
    }
}
