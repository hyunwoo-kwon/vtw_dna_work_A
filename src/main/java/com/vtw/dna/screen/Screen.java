package com.vtw.dna.screen;

import com.vtw.dna.movie.Movie;
import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.util.stream.Stream;

@Entity
@Data
public class Screen {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenSeq;  //상영표 시퀀스

    private Long movieSeq;    //영화 시퀀스

    private Long screenRoomSeq;  //상영관
    
    private String screenDate;  //상영일

    private Integer screenRound; //상영회차

    private Integer startTime;   //상영시작시간

    private Integer endTime;     //상영종료시간
    
    @Transient private Integer basicFee = 0;    //1인 기본요금
    
    @Transient private Integer discountFee = 0; //할인 비용

    @Transient private Integer totalFee = 0;    //1인 총액

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "screenRoomSeq", referencedColumnName="screenRoomSeq", nullable = false, insertable = false, updatable = false)
    private ScreenRoom screenRoom;

    public Screen(){

    }

    //생성자
    public Screen(Long movieSeq, String screenDate, Integer screenRound, Integer startTime, Integer endTime){
        this.movieSeq = movieSeq;
        this.screenDate = screenDate;
        this.screenRound = screenRound;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    //수정
    public void updateScreen(Long movieSeq, String screenDate, Integer screenRound, Integer startTime, Integer endTime){
        this.movieSeq = movieSeq;
        this.screenDate = screenDate;
        this.screenRound = screenRound;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //가격 책정
    public void setCalcFee() throws ParseException {
        this.basicFee = this.movie.getFee();

        if(movie.getDiscountPolicy() == null ){
            this.discountFee = 0;
        }else{
            this.discountFee = this.movie.getDiscountPolicy().calcDiscountFee(this.screenRound, this.screenDate, this.startTime);
        }

        this.totalFee = this.basicFee - this.discountFee;
    }

    //삭제
    public void deleteScreen(Long screenSeq){
        this.screenSeq = screenSeq;
    }


}
