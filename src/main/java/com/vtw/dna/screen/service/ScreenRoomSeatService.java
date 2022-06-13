package com.vtw.dna.screen.service;

import com.vtw.dna.screen.ScreenRoom;
import com.vtw.dna.screen.ScreenRoomSeat;
import com.vtw.dna.screen.repository.ScreenRoomSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomSeatService {

    @Autowired
    private ScreenRoomSeatRepository screenRoomSeatRepository = null;

    @Autowired
    private ScreenRoomService screenRoomService = null;

    public ScreenRoomSeat insertScreenRoomSeat(Long screenRoomSeq){

        ScreenRoom selectScreenRoom = screenRoomService.selectScreenRoomByScreenRoomSeq(screenRoomSeq);

        //행 for문
        char c = selectScreenRoom.getTotalSeatLow().charAt(0);

        for(char i = c; i >='A' ; i--){
            for(int seati = 1 ; seati <= selectScreenRoom.getTotalSetColumn(); seati++){
                ScreenRoomSeat ins = new ScreenRoomSeat(screenRoomSeq,String.valueOf((char)i),seati,"Y");
                screenRoomSeatRepository.save(ins);
            }
        }
        //열 for문

//        screenRoomSeatRepository.save(screenRoomSeat);

        return new ScreenRoomSeat();

    }

    /**
     * screenRoomSeatSeq 검색으로 업데이트
     * @param screenRoomSeatSeq
     * @param useYn
     * @return
     */
    public ScreenRoomSeat updateScreenRoomSeatByScreenRomSeqAndLowAndColumn(Long screenRoomSeatSeq, String useYn){

        ScreenRoomSeat selectSeat = screenRoomSeatRepository.findByScreenRoomSeatSeq(screenRoomSeatSeq);

        selectSeat.updateScreenRoomSeat(useYn);

        screenRoomSeatRepository.save(selectSeat);

        return selectSeat;

    }

    /**
     * 상영관/행/열 검색으로 업데이트
     * @param screenRoomSeq
     * @param seatLow
     * @param seatColumn
     * @param useYn
     * @return
     */
    public ScreenRoomSeat updateScreenRoomSeatByScreenRomSeqAndLowAndColumn(Long screenRoomSeq, String seatLow, Integer seatColumn, String useYn){

        ScreenRoomSeat selectSeat = selectAllScreenRoomSeat( screenRoomSeq, seatLow, seatColumn);

        selectSeat.updateScreenRoomSeat(useYn);

        screenRoomSeatRepository.save(selectSeat);

        return selectSeat;

    }

    public List<ScreenRoomSeat> selectAllScreenRoomSeat(){

        return screenRoomSeatRepository.findAll();

    }

    public ScreenRoomSeat selectAllScreenRoomSeat(Long screenRoomSeq, String seatLow, Integer seatColumn){

        return screenRoomSeatRepository.findByScreenRoomSeqAndSeatLowAndSeatColumn(screenRoomSeq, seatLow, seatColumn);

    }

    public List<ScreenRoomSeat> selectScreenRoomSeatByscreenRoomSeq(Long screenRoomSeq){

        return screenRoomSeatRepository.findByScreenRoomSeqOrderBySeatLowAsc(screenRoomSeq);

    }

}
