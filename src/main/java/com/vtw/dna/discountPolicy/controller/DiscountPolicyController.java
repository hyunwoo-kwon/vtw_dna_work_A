package com.vtw.dna.discountPolicy.controller;

import com.vtw.dna.discountPolicy.DiscountPolicy;
import com.vtw.dna.discountPolicy.service.DiscountPolicyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/discountpolicy")
public class DiscountPolicyController {

    @Autowired private DiscountPolicyService discountPolicyService;

    @PostMapping("/insert")
    public void insertDiscountPolicy (DiscountPolicy discountPolicy){

        discountPolicyService.insertDiscountPolicy(discountPolicy);

    }

}
