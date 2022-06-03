package com.vtw.dna.reservation;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountPolicy.DiscountPolicy;
import com.vtw.dna.movie.Movie;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reservation {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationSeq;  //예매 시퀀스

    private String userId;      //사용자시퀀스

    private Long movieSeq;       //영화 시퀀스

    private int headCount;      //예매인원

    private Long discountPolicySeq;    //할인 정책 시퀀스

    private Long discountConditionSeq; //할인 조건 시퀀스

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "discountPolicySeq", referencedColumnName="discountPolicySeq", nullable = false, insertable = false, updatable = false)
    private DiscountPolicy discountPolicy;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "discountConditionSeq", referencedColumnName="discountConditionSeq", nullable = false, insertable = false, updatable = false)
    private DiscountCondition discountCondition;

    public Reservation(){

    }

    //생성자
    public void Reservation(String userId, int headCount, Long discountPolicySeq, Long discountConditionSeq){
        this.userId = userId;
        this.headCount = headCount;
        this.discountPolicySeq = discountPolicySeq;
        this.discountConditionSeq = discountConditionSeq;
    }

    //수정
    public void updateReservation(String userId, int headCount, Long discountPolicySeq, Long discountConditionSeq){
        this.userId = userId;
        this.headCount = headCount;
        this.discountPolicySeq = discountPolicySeq;
        this.discountConditionSeq = discountConditionSeq;

    }

    //삭제
    public void deleteReservation(Long reservationSeq){
        this.reservationSeq = reservationSeq;
    }


}
