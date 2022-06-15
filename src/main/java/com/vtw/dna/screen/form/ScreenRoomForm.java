package com.vtw.dna.screen.form;

import com.vtw.dna.screen.ScreenRoomSeat;
import lombok.Data;

public class ScreenRoomForm {

    @Data
    public static class Resonse {
        private Long    screenRoomSeq       = null;
        private String  totalSeatRow        = null;
        private Integer totalSeatColumn     = null;
        private ScreenRoomSeat[] screenRoomSeatList = null;
        private String[] screenRoomSeatListSeatLow = null;
    }

    @Data
    public static class ResonseList {
        private String seatRow = null;
        private Integer seatColumn = null;
    }

}
