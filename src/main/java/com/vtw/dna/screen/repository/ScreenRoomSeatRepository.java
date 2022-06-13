package com.vtw.dna.screen.repository;

import com.vtw.dna.screen.ScreenRoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRoomSeatRepository extends JpaRepository<ScreenRoomSeat, Long> {

    List<ScreenRoomSeat> findByScreenRoomSeqOrderBySeatLowAsc(Long screenRoomSeq);

    ScreenRoomSeat findByScreenRoomSeqAndSeatLowAndSeatColumn(Long screenRoomSeq, String seatLow, Integer seatColumn);

    ScreenRoomSeat findByScreenRoomSeatSeq(Long screenRoomSeatSeq);

}
