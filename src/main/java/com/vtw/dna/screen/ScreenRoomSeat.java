package com.vtw.dna.screen;

import com.vtw.dna.discountPolicy.DiscountPolicy;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ScreenRoomSeat {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    screenRoomSeatSeq;  //상영관 자리 시퀀스

    private Long    screenRoomSeq;  //상영관 시퀀스

    private String  seatLow;        //상영관 자리 행

    private Integer seatColumn;         //상영관 자리 열

    private String  useYn;          //사용여부

//    @OneToOne(fetch = FetchType.EAGER, optional = true)
//    @JoinColumn(name = "screenRoomSeq", referencedColumnName="screenRoomSeq", nullable = false, insertable = false, updatable = false)
//    private ScreenRoom screenRoom;

    public ScreenRoomSeat() {

    }

    //생성자
    public ScreenRoomSeat(Long screenRoomSeq, String  seatLow, Integer seatColumn, String  useYn){
        this.screenRoomSeq = screenRoomSeq;
        this.seatLow = seatLow;
        this.seatColumn = seatColumn;
        this.useYn = useYn;

    }

    //수정
    public void updateScreenRoomSeat(String  useYn){
        this.useYn = useYn;

    }

    //삭제
    public void deleteScreenRoomSeat(Long screenRoomSeatSeq) { this.screenRoomSeatSeq = screenRoomSeatSeq;}



}
