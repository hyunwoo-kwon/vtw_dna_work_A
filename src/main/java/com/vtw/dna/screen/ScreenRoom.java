package com.vtw.dna.screen;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountPolicy.DiscountPolicy;
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

    private String    totalSeatLow;    //상영관 총 행

    private Integer  totalSetColumn;  //상영관 총 열

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "screenRoomSeq", referencedColumnName="screenRoomSeq", nullable = false, insertable = false, updatable = false)
    private List<ScreenRoomSeat> screenRoomSeatList;

    public ScreenRoom() {

    }

    //생성자
    public ScreenRoom(String totalSeatLow, Integer  totalSetColumn){
        this.totalSeatLow = totalSeatLow;
        this.totalSetColumn = totalSetColumn;

    }

    //수정
    public void updateScreenRoom(String totalSeatLow, Integer  totalSetColumn){
        this.totalSeatLow = totalSeatLow;
        this.totalSetColumn = totalSetColumn;

    }

    //삭제
    public void deleteScreenRoom(Long screenRoomSeatSeq) { this.screenRoomSeq = screenRoomSeq;}
}
