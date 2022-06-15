package com.vtw.dna.sample;

import com.vtw.dna.screen.service.ScreenRoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Configuration
@Component
public class sampleDataConfig  {

    @Autowired private ScreenRoomInitializer screenRoomInitializer;

    @Autowired private MovieInitializer movieInitializer;

    @Autowired private ScreenInitializer screenInitializer;

    @PostConstruct
    public void init() {
        screenRoomInitializer.generateData();

        movieInitializer.generateData();

        screenInitializer.generateData();
    }



}
