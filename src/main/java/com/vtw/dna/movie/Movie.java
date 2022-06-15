package com.vtw.dna.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountPolicy.DiscountPolicy;
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

    private String imageLocate;  //이미지 정보

    private Integer fee; // 가격

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private DiscountPolicy discountPolicy;

    public Movie() {

    }

    //생성자
    public Movie(String krName, String enName, String releaseDate, String detail, String imageLocate, Integer fee) {
        this.krName = krName;
        this.enName = enName;
        this.releaseDate = releaseDate;
        this.detail = detail;
        this.imageLocate = imageLocate;
        this.fee = fee;
    }

    //수정
    public void updateMovie(String krName, String enName, String releaseDate, String detail, Integer fee){
        this.krName = krName;
        this.enName = enName;
        this.releaseDate = releaseDate;
        this.detail = detail;
        this.fee = fee;
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
        this.fee = newMovie.fee;
        return this;
    }
}
