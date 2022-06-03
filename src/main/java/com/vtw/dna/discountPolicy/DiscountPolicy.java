package com.vtw.dna.discountPolicy;

import com.vtw.dna.movie.Movie;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DiscountPolicy {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountPolicySeq;  //할인 정책 시퀀스

    private Long movieSeq;       //영화 시퀀스

    private int policyType;     //정책 타입

    private int polictPrice;    //할인 금액

    private int policyRate;     //할인 비율

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    public DiscountPolicy(){

    }

    //생성자
    public void DiscountPolicy(Long movieSeq, int policyType, int polictPrice, int policyRate){
        this.movieSeq = movieSeq;
        this.policyType = policyType;
        this.polictPrice = polictPrice;
        this.policyRate = policyRate;
    }

    //수정
    public void updateDiscountPolicy(Long movieSeq, int policyType, int polictPrice, int policyRate){
        this.movieSeq = movieSeq;
        this.policyType = policyType;
        this.polictPrice = polictPrice;
        this.policyRate = policyRate;
    }

    //삭제
    public void deleteDiscountPolicy(Long discountPolicySeq){
        this.discountPolicySeq = discountPolicySeq;
    }

}
