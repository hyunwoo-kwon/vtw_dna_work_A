package com.vtw.dna.discountCondition;

import com.vtw.dna.discountPolicy.DiscountPolicy;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DiscountCondition {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountConditionSeq;  //할인 조건 시퀀스

    private Long discountPolicySeq;     //할인 정책 시퀀스

    private int conditionType;          //조건 타입

    private int conditionRound;         //조건 순번

    private int conditionStartTime;     //조건 시간 시작

    private int conditionEndTime;       //조건 시간 종료

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "discountPolicySeq", referencedColumnName="discountPolicySeq", nullable = false, insertable = false, updatable = false)
    private DiscountPolicy discountPolicy;

}
