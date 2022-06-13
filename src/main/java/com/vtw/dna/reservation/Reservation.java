package com.vtw.dna.reservation;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountPolicy.DiscountPolicy;
import com.vtw.dna.movie.Movie;
import com.vtw.dna.screen.Screen;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationSeq;//예매 시퀀스

    private String userId;      //사용자시퀀스

    private Long screenSeq;     //상영 시퀀스

    private Integer headCount;  //예매인원

    private Integer unitFee;    //1인당 금액

    private Integer totalFee;   //총 금액

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "screenSeq", referencedColumnName="screenSeq", nullable = false, insertable = false, updatable = false)
    private Screen screen;

    public Reservation(){

    }

    //생성자
    public void Reservation(String userId, Long screenSeq, Integer headCount, Integer unitFee, Integer totalFee){
        this.userId = userId;
        this.screenSeq = screenSeq;
        this.headCount = headCount;
        this.unitFee = unitFee;
        this.totalFee = totalFee;
    }

    //수정
    public void updateReservation(String userId, Long screenSeq, Integer headCount, Integer unitFee, Integer totalFee){
        this.userId = userId;
        this.screenSeq = screenSeq;
        this.headCount = headCount;
        this.unitFee = unitFee;
        this.totalFee = totalFee;

    }

    //삭제
    public void deleteReservation(Long reservationSeq){
        this.reservationSeq = reservationSeq;
    }


}
