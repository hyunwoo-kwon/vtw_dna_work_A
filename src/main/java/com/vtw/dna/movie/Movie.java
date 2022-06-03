package com.vtw.dna.movie;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Movie {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;  //영화 기초정보 시퀀스

    private String krName;  //국문명

    private String enName;  //영문명

    private String releaseDate; //개봉일

    private String detail;  //상세정보

    public Movie() {

    }

    //생성자
    public Movie(String krName, String enName, String releaseDate, String detail) {
        this.krName = krName;
        this.enName = enName;
        this.releaseDate = releaseDate;
        this.detail = detail;
    }

    //수정
    public void updateMovie(String krName, String enName, String releaseDate, String detail){
        this.krName = krName;
        this.enName = enName;
        this.releaseDate = releaseDate;
        this.detail = detail;
    }

    //삭제
    public void deleteMovie(Long movieSeq){
        this.movieSeq = movieSeq;
    }

    public Movie insert(Movie newMovie){
        this.krName = newMovie.krName;
        this.enName = newMovie.enName;
        this.releaseDate = newMovie.releaseDate;
        this.detail = newMovie.detail;
        return this;
    }
}
