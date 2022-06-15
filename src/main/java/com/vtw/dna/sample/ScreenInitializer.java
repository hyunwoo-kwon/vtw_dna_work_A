package com.vtw.dna.sample;

import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.repository.ScreenRepository;
import com.vtw.dna.screen.repository.ScreenRoomRepository;
import com.vtw.dna.screen.service.ScreenRoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenInitializer implements SampleDataInitializer{

    private final ScreenRepository repository;


    public ScreenInitializer(ScreenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateData() {

        Screen screen1 = new Screen(new Long(1),new Long(1), "202203", 1, 900,1000);
        Screen screen2 = new Screen(new Long(1),new Long(2), "202203", 1, 900,1000);
        Screen screen3 = new Screen(new Long(1),new Long(1), "202203", 1, 1200,1000);

        Screen screen4 = new Screen(new Long(2),new Long(1), "202203", 1, 900,1000);
        Screen screen5 = new Screen(new Long(2),new Long(2), "202203", 1, 900,1000);
        Screen screen6 = new Screen(new Long(2),new Long(1), "202203", 1, 1200,1000);

        Screen screen7 = new Screen(new Long(3),new Long(1), "202203", 1, 900,1000);
        Screen screen8 = new Screen(new Long(3),new Long(2), "202203", 1, 900,1000);
        Screen screen9 = new Screen(new Long(3),new Long(1), "202203", 1, 1200,1000);

        create(screen1);
        create(screen2);
        create(screen3);

        create(screen4);
        create(screen5);
        create(screen6);

        create(screen7);
        create(screen8);
        create(screen9);

    }

    private void create(Screen screenRoom){
        repository.save(screenRoom);
    }
}
