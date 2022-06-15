package com.vtw.dna.screen;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ScreenRoom {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    screenRoomSeq;  //상영관 시퀀스

    private String totalSeatRow;    //상영관 총 행

    private Integer totalSeatColumn;  //상영관 총 열

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "screenRoomSeq", referencedColumnName="screenRoomSeq", nullable = false, insertable = false, updatable = false)
    @OrderBy("seatRow asc, seatColumn asc ")
    private List<ScreenRoomSeat> screenRoomSeatList;

    public ScreenRoom() {

    }

    //생성자
    public ScreenRoom(String totalSeatRow, Integer totalSeatColumn){
        this.totalSeatRow = totalSeatRow;
        this.totalSeatColumn = totalSeatColumn;

    }

    //수정
    public void updateScreenRoom(String totalSeatLow, Integer  totalSetColumn){
        this.totalSeatRow = totalSeatLow;
        this.totalSeatColumn = totalSetColumn;

    }

    //삭제
    public void deleteScreenRoom(Long screenRoomSeatSeq) { this.screenRoomSeq = screenRoomSeq;}
}
