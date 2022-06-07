package com.vtw.dna.discountPolicy;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.movie.Movie;
import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.util.List;

@Entity
@Data
public class DiscountPolicy {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountPolicySeq;  //할인 정책 시퀀스

    private Long movieSeq;       //영화 시퀀스

    private Integer policyType;     //정책 타입 1:할인 금액 , 2:할인 비율

    private Integer polictPrice;    //할인 금액

    private Integer policyRate;     //할인 비율

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "movieSeq", referencedColumnName="movieSeq", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "discountPolicySeq", referencedColumnName="discountPolicySeq", nullable = false, insertable = false, updatable = false)
    private List<DiscountCondition> discountConditionList;

    public DiscountPolicy(){

    }

    //생성자
    public void DiscountPolicy(Long movieSeq, Integer policyType, Integer polictPrice, Integer policyRate){
        this.movieSeq = movieSeq;
        this.policyType = policyType;
        this.polictPrice = polictPrice;
        this.policyRate = policyRate;
    }

    //수정
    public void updateDiscountPolicy(Long movieSeq, Integer policyType, Integer polictPrice, Integer policyRate){
        this.movieSeq = movieSeq;
        this.policyType = policyType;
        this.polictPrice = polictPrice;
        this.policyRate = policyRate;
    }

    public Integer calcDiscountFee(Integer screenRound, String screenDate, Integer screenStartDate) throws ParseException {
        Integer discountFee = 0;
        boolean calc = false;

        for(DiscountCondition one : this.discountConditionList){
            calc=one.calcDiscountFee(screenRound, screenDate, screenStartDate);

            if(calc==true){
                switch(this.policyType){
                    //1: 할인 금액
                    case 1: discountFee=movie.getFee()-this.polictPrice;
                    //2: 할인 비율
                    case 2: discountFee=movie.getFee()/100*this.policyRate;
                }

                break;
            }
        }
        return discountFee;
    }

    //삭제
    public void deleteDiscountPolicy(Long discountPolicySeq){
        this.discountPolicySeq = discountPolicySeq;
    }

}
