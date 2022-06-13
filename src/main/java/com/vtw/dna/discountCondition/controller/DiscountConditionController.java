package com.vtw.dna.discountCondition.controller;

import com.vtw.dna.discountCondition.DiscountCondition;
import com.vtw.dna.discountCondition.service.DiscountConditionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/discountcondition")
public class DiscountConditionController {

    @Autowired private DiscountConditionService discountConditionService;

    @PostMapping("/insert")
    public void insertDiscountCondition(DiscountCondition discountCondition){

        discountConditionService.insertDiscountCondition(discountCondition);

    }

}
