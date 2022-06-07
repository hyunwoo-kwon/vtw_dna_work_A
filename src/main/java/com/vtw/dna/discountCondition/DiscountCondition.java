package com.vtw.dna.discountCondition;

import com.vtw.dna.Udate;
import com.vtw.dna.discountPolicy.DiscountPolicy;
import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;

@Entity
@Data
public class DiscountCondition {

    @Id
    @Column(insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountConditionSeq;  //할인 조건 시퀀스

    private Long discountPolicySeq;     //할인 정책 시퀀스

    private Integer conditionType;          //조건 타입 (1:순번,2:시작시간)

    private Integer dateDay;                //요일 조건 0-조건 없음, 1-일, 2-월, 3-화, 4-수, 5-목, 6-금, 7-토

    private Integer conditionRound;         //조건 순번

    private Integer conditionStartTime;     //조건 시간 시작

    private Integer conditionEndTime;       //조건 시간 종료

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "discountPolicySeq", referencedColumnName="discountPolicySeq", nullable = false, insertable = false, updatable = false)
    private DiscountPolicy discountPolicy;

    public boolean calcDiscountFee(Integer screenRound, String screenDate, Integer screenStartDate) throws ParseException {

        boolean returnDiscountYN = false;

        if(this.dateDay.equals(0) || dateDay.equals(Udate.getDateDay(screenDate))){

            switch (conditionType){
                //0-요일 조건일 경우
                case 0 : returnDiscountYN = true;

                //1-순번 조건일 경우
                case 1 : if(this.conditionRound.equals(screenRound)) returnDiscountYN = true;

                //2-시간 조건일 경우
                case 2 : if(screenStartDate>=conditionStartTime && screenStartDate<=conditionEndTime) returnDiscountYN = true;

            }

        }

       return returnDiscountYN;
    }

}
