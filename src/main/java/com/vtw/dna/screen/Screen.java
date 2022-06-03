package com.vtw.dna.screen;

import com.vtw.dna.movie.Movie;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Screen {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenSeq;  //상영표 시퀀스

    private Long movieSeq;    //영화 시퀀스

    private int screenDate;  //상영일

    private int screenRound; //상영회차

    private int startTime;   //상영시작시간

    private int endTime;     //상영종료시간

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    public Screen(){

    }

    //생성자
    public Screen(Long movieSeq, int screenDate, int screenRound, int startTime, int endTime){
        this.movieSeq = movieSeq;
        this.screenDate = screenDate;
        this.screenRound = screenRound;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    //수정
    public void updateScreen(Long movieSeq, int screenDate, int screenRound, int startTime, int endTime){
        this.movieSeq = movieSeq;
        this.screenDate = screenDate;
        this.screenRound = screenRound;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //삭제
    public void deleteScreen(Long screenSeq){
        this.screenSeq = screenSeq;
    }


}
